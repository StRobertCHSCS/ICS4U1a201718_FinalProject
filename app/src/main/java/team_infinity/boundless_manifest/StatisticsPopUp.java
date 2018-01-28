package team_infinity.boundless_manifest;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

import org.w3c.dom.Text;

import static team_infinity.boundless_manifest.GlobalAttributes.currentSelectedSubject;
import static team_infinity.boundless_manifest.GlobalAttributes.numQuestionAnswered;

/**
 * Created by Vallyath on 2018-01-27.
 */

public class StatisticsPopUp extends android.support.v4.app.DialogFragment {

    public Dialog onCreateDialog (Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.stats_popup, null);
        ImageView currChar = (ImageView)dialogView.findViewById(R.id.currChar);

        if(currentSelectedSubject.equals("data")) {
            currChar.setImageResource(R.drawable.game_gambler);
        }
        else if (currentSelectedSubject.equals("chemistry")) {
            currChar.setImageResource(R.drawable.game_alchemist3);
        }
        else{
            currChar.setImageResource(R.drawable.ic_launcher_background);
        }

        GraphView currGameGraph = (GraphView) dialogView.findViewById(R.id.currGameGraph);
            currGameGraph.setTitle("Current Attribute Statistics");
        BarGraphSeries<DataPoint> knowledge = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0.2, GlobalAttributes.knowledgeAtt)
        });
        currGameGraph.addSeries(knowledge);
        knowledge.setTitle("Knowledge");
        currGameGraph.addSeries(knowledge);

        BarGraphSeries<DataPoint> thinking = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0.5, GlobalAttributes.thinkingAtt)
        });
        thinking.setTitle("Thinking");
        currGameGraph.addSeries(thinking);

        BarGraphSeries<DataPoint> understanding = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0.8, GlobalAttributes.understandingAtt)
        });

        thinking.setTitle("Understanding");
        currGameGraph.addSeries(understanding);

        BarGraphSeries<DataPoint> total = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0, numQuestionAnswered),
                new DataPoint(1, numQuestionAnswered),
                new DataPoint(2, numQuestionAnswered)

        });
        total.setTitle("Total");
        currGameGraph.addSeries(total);

        currGameGraph.getLegendRenderer().setVisible(true);
        currGameGraph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);



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

