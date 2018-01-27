package team_infinity.boundless_manifest;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;

import org.w3c.dom.Text;

/**
 * Created by Vallyath on 2018-01-27.
 */

public class StatisticsPopUp extends android.support.v4.app.DialogFragment {

    public Dialog onCreateDialog (Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.stats_popup, null);
        ImageView currChar = (ImageView)dialogView.findViewById(R.id.currChar);

        /*
       not yet in place
        if(currentCharacter == "Dexter"){
         currChar.setImageResource(R.drawable-xxhdpi.game_gambler);
        else if(currentCharacter == "Paulline"){
         currChar.setImageResource(R.drawable-xxhdpi.game_alchemist);
        }
        else{
        set to a blank image
        }
        */
        GraphView currGameGraph = (GraphView)dialogView.findViewById(R.id.currGameGraph);
        currGameGraph.setTitle("Current Attribute Statistics");

        builder.setView(dialogView).setMessage("");
        return builder.create();
        }

        public View getView(View view, ViewGroup viewGroup){

            if(view == null){
                LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.continuequest, viewGroup, false);
            }

            return view;
        }
    }

