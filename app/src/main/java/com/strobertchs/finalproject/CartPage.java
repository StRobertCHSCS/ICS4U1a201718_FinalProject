package com.strobertchs.finalproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.strobertchs.finalproject.adapter.CartAdapter;
import com.strobertchs.finalproject.messaging.CafeteriaFirebaseInstanceIdService;
import com.strobertchs.finalproject.model.Cart;
import com.strobertchs.finalproject.model.Order;
import com.strobertchs.finalproject.model.SavedUsers;
import com.strobertchs.finalproject.model.User;
import com.strobertchs.finalproject.utils.Constants;
import com.strobertchs.finalproject.utils.ViewUtils;

import java.util.Date;

/**
 * Cart page shows all cart items to be checked out.
 * @author jenny
 */
public class CartPage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ListView cartItemListView;
    private CartAdapter cartAdapter;

    FirebaseDatabase database;
    DatabaseReference ordersRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_page);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Cart");
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        cartItemListView = (ListView)findViewById(R.id.cartItemList);
        cartAdapter = new CartAdapter(this, Home.SHOPPING_CART.getCartItemList());
        cartItemListView.setAdapter(cartAdapter);

        TextView txtSubTotalPrice = (TextView)findViewById(R.id.subTotalPrice);
        TextView txtTax = (TextView)findViewById(R.id.tax);
        TextView txtTotalPrice = (TextView)findViewById(R.id.totalPrice);
        txtSubTotalPrice.setText(Home.SHOPPING_CART.getFormattedSubtotal());
        txtTax.setText(Home.SHOPPING_CART.getFormattedTotalTax());
        txtTotalPrice.setText(Home.SHOPPING_CART.getFormattedTotal());

        Button btnPlace = (Button)findViewById(R.id.btnPlaceOrder);
        btnPlace.setText("Place Order");

        btnPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(Home.SHOPPING_CART.getCartItemList().size()==0){
                    Toast.makeText(CartPage.this, "Nothing in your cart.", Toast.LENGTH_SHORT).show();
                    return;
                }

                //prepare order
                User orderUser = SavedUsers.getCurrentUser();
                Order o = new Order(Home.SHOPPING_CART.getCartItemList(), Constants.ORDER_OPENED, orderUser.getEmail(),
                        ViewUtils.getTimeStampString(new Date()), Home.SHOPPING_CART.getTaxRate());
                String orderNum = o.getOrderDateTime();

                //Submit order to database
                database = FirebaseDatabase.getInstance();
                ordersRef = database.getReference("Orders");
                ordersRef.child(orderNum).setValue(o);

                CafeteriaFirebaseInstanceIdService.sendRegistrationToServer(FirebaseInstanceId.getInstance().getToken());

                //Show order information
                AlertDialog.Builder dialog = new AlertDialog.Builder(CartPage.this);

                dialog.setTitle( "Order Confirmation" )
                        .setMessage("You will be notified once it's ready.\n Order # " + orderNum)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialoginterface, int i) {
                                Intent intent = new Intent(CartPage.this, Home.class);
                                startActivity(intent);
                            }
                        }).show();

                //reset cart
                Home.SHOPPING_CART = new Cart(0.13);
                //subscribe to the notifications
                //FirebaseMessaging.getInstance().subscribeToTopic("notifications");
            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_menu) {
            Intent i = null;
            i = new Intent(this, new Home().getClass());
            startActivity(i);
        }

        else if (id == R.id.nav_log_out) {
            SavedUsers.deleteCurrentUser();
            Intent i = new Intent(this, new FinalProject().getClass());
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}

