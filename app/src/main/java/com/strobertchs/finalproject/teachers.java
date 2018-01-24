package com.strobertchs.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;

public class teachers extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachers);

        ListView lv_teachers = (ListView)findViewById(R.id.listViewTeachers);

        ArrayList<String> arrayTeachers = new ArrayList<>();
        arrayTeachers.addAll(Arrays.asList(getResources().getStringArray(R.array.array_teachers)));

        adapter = new ArrayAdapter<>(
                teachers.this,
                android.R.layout.simple_list_item_1,
                arrayTeachers);
        lv_teachers.setAdapter(adapter);
        lv_teachers.setOnItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search,menu);
        MenuItem item = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query){
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText){
                adapter.getFilter().filter(newText);

                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position==0){
            Intent teachers_intent = new Intent(view.getContext(),teachers_alshaikh.class);
            startActivityForResult(teachers_intent,0);
        }
        if (position==1){
            Intent teachers_intent = new Intent(view.getContext(),teachers_albi.class);
            startActivityForResult(teachers_intent, 1);
        }
        if (position==2){
            Intent teachers_intent = new Intent(view.getContext(),teachers_ashworth.class);
            startActivityForResult(teachers_intent, 2);
        }
        if (position==3){
            Intent teachers_intent = new Intent(view.getContext(),teachers_battaglia.class);
            startActivityForResult(teachers_intent, 3);
        }
        if (position==4){
            Intent teachers_intent = new Intent(view.getContext(),teachers_bianchi.class);
            startActivityForResult(teachers_intent,4);
        }
        if (position==5){
            Intent teachers_intent = new Intent(view.getContext(),teachers_boccia.class);
            startActivityForResult(teachers_intent, 5);
        }
        if (position==6){
            Intent teachers_intent = new Intent(view.getContext(),teachers_bottiglione.class);
            startActivityForResult(teachers_intent, 6);
        }
        if (position==7){
            Intent teachers_intent = new Intent(view.getContext(),teachers_brockest.class);
            startActivityForResult(teachers_intent,7);
        }
        if (position==8){
            Intent teachers_intent = new Intent(view.getContext(),teachers_buchignani.class);
            startActivityForResult(teachers_intent, 8);
        }
        if (position==9){
            Intent teachers_intent = new Intent(view.getContext(), teachers_buckley.class);
            startActivityForResult(teachers_intent, 9);
        }
        if (position==10){
            Intent teachers_intent = new Intent(view.getContext(), teachers_bumbaca.class);
            startActivityForResult(teachers_intent,10);
        }
        if (position==11){
            Intent teachers_intent = new Intent(view.getContext(), teachers_cappelli.class);
            startActivityForResult(teachers_intent, 11);
        }
        if (position==12){
            Intent teachers_intent = new Intent(view.getContext(), teachers_capuccinello.class);
            startActivityForResult(teachers_intent, 12);
        }
        if (position==13){
            Intent teachers_intent = new Intent(view.getContext(), teachers_cara.class);
            startActivityForResult(teachers_intent, 13);
        }
        if (position==14){
            Intent teachers_intent = new Intent(view.getContext(), teachers_carone.class);
            startActivityForResult(teachers_intent, 14);
        }
        if (position==15){
            Intent teachers_intent = new Intent(view.getContext(), teachers_catenaro.class);
            startActivityForResult(teachers_intent, 15);
        }
        if (position==16){
            Intent teachers_intent = new Intent(view.getContext(), teachers_chan.class);
            startActivityForResult(teachers_intent, 16);
        }
        if (position==17) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_chirrey.class);
            startActivityForResult(teachers_intent,17);
        }
        if (position==18) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_ciarallo.class);
            startActivityForResult(teachers_intent,18);
        }
        if (position==19) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_ciobanu.class);
            startActivityForResult(teachers_intent,19);
        }
        if (position==20) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_cisternino.class);
            startActivityForResult(teachers_intent,20);
        }
        if (position==21) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_civiero.class);
            startActivityForResult(teachers_intent,21);
        }
        if (position==22) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_coda.class);
            startActivityForResult(teachers_intent,22);
        }
        if (position==23) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_cooney.class);
            startActivityForResult(teachers_intent,23);
        }
        if (position==24) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_covre.class);
            startActivityForResult(teachers_intent,24);
        }
        if (position==25) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_cruz.class);
            startActivityForResult(teachers_intent,25);
        }
        if (position==26) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_curik.class);
            startActivityForResult(teachers_intent,26);
        }
        if (position==27) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_damphouse.class);
            startActivityForResult(teachers_intent,27);
        }
        if (position==28) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_defina.class);
            startActivityForResult(teachers_intent,28);
        }
        if (position==29) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_degregorio_boichevski.class);
            startActivityForResult(teachers_intent,29);
        }
        if (position==30) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_delia.class);
            startActivityForResult(teachers_intent,30);
        }
        if (position==31) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_devine.class);
            startActivityForResult(teachers_intent,31);
        }
        if (position==32) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_dicarlo.class);
            startActivityForResult(teachers_intent,32);
        }
        if (position==33) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_digirolamo.class);
            startActivityForResult(teachers_intent,33);
        }
        if (position==34) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_dinunzio.class);
            startActivityForResult(teachers_intent,34);
        }
        if (position==35) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_do.class);
            startActivityForResult(teachers_intent,35);
        }
        if (position==36) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_durrant.class);
            startActivityForResult(teachers_intent,36);
        }
        if (position==37) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_fabroa.class);
            startActivityForResult(teachers_intent,37);
        }
        if (position==38) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_facchini.class);
            startActivityForResult(teachers_intent,38);
        }
        if (position==39) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_ferrari.class);
            startActivityForResult(teachers_intent,39);
        }
        if (position==40) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_galatianos.class);
            startActivityForResult(teachers_intent,40);
        }
        if (position==41) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_gallo.class);
            startActivityForResult(teachers_intent,41);
        }
        if (position==42) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_gallucci.class);
            startActivityForResult(teachers_intent,42);
        }
        if (position==43) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_garofalo.class);
            startActivityForResult(teachers_intent,43);
        }
        if (position==44) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_giang.class);
            startActivityForResult(teachers_intent,44);
        }
        if (position==45) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_grah.class);
            startActivityForResult(teachers_intent,45);
        }
        if (position==46) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_gueli.class);
            startActivityForResult(teachers_intent,46);
        }
        if (position==47) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_guerrisi_a.class);
            startActivityForResult(teachers_intent,47);
        }
        if (position==48) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_guerrisi_j.class);
            startActivityForResult(teachers_intent,48);
        }
        if (position==49) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_gurunlian.class);
            startActivityForResult(teachers_intent,49);
        }
        if (position==50) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_hall_j.class);
            startActivityForResult(teachers_intent,50);
        }
        if (position==51) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_hall_m.class);
            startActivityForResult(teachers_intent,51);
        }
        if (position==52) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_hasiuk.class);
            startActivityForResult(teachers_intent,52);
        }
        if (position==53) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_holding.class);
            startActivityForResult(teachers_intent,53);
        }
        if (position==54) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_hord.class);
            startActivityForResult(teachers_intent,54);
        }
        if (position==55) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_jorge.class);
            startActivityForResult(teachers_intent,55);
        }
        if (position==56) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_karges.class);
            startActivityForResult(teachers_intent,56);
        }
        if (position==57) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_klobucar.class);
            startActivityForResult(teachers_intent,57);
        }
        if (position==58) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_koon.class);
            startActivityForResult(teachers_intent,58);
        }
        if (position==59) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_kotulski.class);
            startActivityForResult(teachers_intent,59);
        }
        if (position==60) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_kurtz.class);
            startActivityForResult(teachers_intent,60);
        }
        if (position==61) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_lam.class);
            startActivityForResult(teachers_intent,61);
        }
        if (position==62) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_laviolette.class);
            startActivityForResult(teachers_intent,62);
        }
        if (position==63) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_lecce.class);
            startActivityForResult(teachers_intent,63);
        }
        if (position==64) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_leduc.class);
            startActivityForResult(teachers_intent,64);
        }
        if (position==65) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_loffredi.class);
            startActivityForResult(teachers_intent,65);
        }
        if (position==66) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_lothian.class);
            startActivityForResult(teachers_intent,66);
        }
        if (position==67) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_macdonald.class);
            startActivityForResult(teachers_intent,67);
        }
        if (position==68) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_mak.class);
            startActivityForResult(teachers_intent,68);
        }
        if (position==69) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_martin.class);
            startActivityForResult(teachers_intent,69);
        }
        if (position==70) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_mastrangelo.class);
            startActivityForResult(teachers_intent,70);
        }
        if (position==71) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_mastroianni.class);
            startActivityForResult(teachers_intent,71);
        }
        if (position==72) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_matchett.class);
            startActivityForResult(teachers_intent,72);
        }
        if (position==73) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_mazzacca.class);
            startActivityForResult(teachers_intent,73);
        }
        if (position==74) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_mcmahon.class);
            startActivityForResult(teachers_intent,74);
        }
        if (position==75) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_meloche.class);
            startActivityForResult(teachers_intent,75);
        }
        if (position==76) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_merlin.class);
            startActivityForResult(teachers_intent,76);
        }
        if (position==77) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_milucci.class);
            startActivityForResult(teachers_intent,77);
        }
        if (position==78) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_molnar.class);
            startActivityForResult(teachers_intent,78);
        }
        if (position==79) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_morale.class);
            startActivityForResult(teachers_intent,79);
        }
        if (position==80) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_morra.class);
            startActivityForResult(teachers_intent,80);
        }
        if (position==81) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_muto.class);
            startActivityForResult(teachers_intent,81);
        }
        if (position==82) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_nagybakos.class);
            startActivityForResult(teachers_intent,82);
        }
        if (position==83) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_nardi.class);
            startActivityForResult(teachers_intent,83);
        }
        if (position==84) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_nelson.class);
            startActivityForResult(teachers_intent,84);
        }
        if (position==85) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_nesci.class);
            startActivityForResult(teachers_intent,85);
        }
        if (position==86) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_palma.class);
            startActivityForResult(teachers_intent,86);
        }
        if (position==87) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_palumbo.class);
            startActivityForResult(teachers_intent,87);
        }
        if (position==88) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_parravani.class);
            startActivityForResult(teachers_intent,88);
        }
        if (position==89) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_pasquali.class);
            startActivityForResult(teachers_intent,89);
        }
        if (position==90) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_pellew.class);
            startActivityForResult(teachers_intent,90);
        }
        if (position==91) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_perry.class);
            startActivityForResult(teachers_intent,91);
        }
        if (position==92) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_power.class);
            startActivityForResult(teachers_intent,92);
        }
        if (position==93) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_pulla.class);
            startActivityForResult(teachers_intent,93);
        }
        if (position==94) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_purdon.class);
            startActivityForResult(teachers_intent,94);
        }
        if (position==95) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_raczynski.class);
            startActivityForResult(teachers_intent,95);
        }
        if (position==96) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_ricupero.class);
            startActivityForResult(teachers_intent,96);
        }
        if (position==97) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_roccari.class);
            startActivityForResult(teachers_intent,97);
        }
        if (position==98) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_rosalinas.class);
            startActivityForResult(teachers_intent,98);
        }
        if (position==99) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_rovere.class);
            startActivityForResult(teachers_intent,99);
        }
        if (position==100) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_sarracini.class);
            startActivityForResult(teachers_intent,100);
        }
        if (position==101) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_scarcello.class);
            startActivityForResult(teachers_intent,101);
        }
        if (position==102) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_schiavone.class);
            startActivityForResult(teachers_intent,102);
        }
        if (position==103) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_scugila.class);
            startActivityForResult(teachers_intent,103);
        }
        if (position==104) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_sersta.class);
            startActivityForResult(teachers_intent,104);
        }
        if (position==105) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_servidio.class);
            startActivityForResult(teachers_intent,105);
        }
        if (position==106) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_sgouros.class);
            startActivityForResult(teachers_intent,106);
        }
        if (position==107) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_simone.class);
            startActivityForResult(teachers_intent,107);
        }
        if (position==108) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_siranni.class);
            startActivityForResult(teachers_intent,108);
        }
        if (position==109) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_steele.class);
            startActivityForResult(teachers_intent,109);
        }
        if (position==110) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_stilo.class);
            startActivityForResult(teachers_intent,110);
        }
        if (position==111) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_sun.class);
            startActivityForResult(teachers_intent,111);
        }
        if (position==112) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_thome.class);
            startActivityForResult(teachers_intent,112);
        }
        if (position==113) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_torresan.class);
            startActivityForResult(teachers_intent,113);
        }
        if (position==114) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_totino.class);
            startActivityForResult(teachers_intent,114);
        }
        if (position==115) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_tsui.class);
            startActivityForResult(teachers_intent,115);
        }
        if (position==116) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_turrin.class);
            startActivityForResult(teachers_intent,116);
        }
        if (position==117) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_u.class);
            startActivityForResult(teachers_intent,117);
        }
        if (position==118) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_villani.class);
            startActivityForResult(teachers_intent,118);
        }
        if (position==119) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_weeks.class);
            startActivityForResult(teachers_intent,119);
        }
        if (position==120) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_wood_r.class);
            startActivityForResult(teachers_intent,120);
        }
        if (position==121) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_wood_s.class);
            startActivityForResult(teachers_intent,121);
        }
        if (position==122) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_yeghiaian.class);
            startActivityForResult(teachers_intent,122);
        }
        if (position==123) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_zasowski.class);
            startActivityForResult(teachers_intent,123);
        }
        if (position==124) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_zmak.class);
            startActivityForResult(teachers_intent,124);
        }
        if (position==125) {
            Intent teachers_intent = new Intent(view.getContext(), teachers_zucchetto.class);
            startActivityForResult(teachers_intent,125);
        }

    }
}
