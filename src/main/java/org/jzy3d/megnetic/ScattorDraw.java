package org.jzy3d.megnetic;

import org.jzy3d.analysis.AbstractAnalysis;
import org.jzy3d.analysis.AnalysisLauncher;
import org.jzy3d.chart.factories.AWTChartComponentFactory;
import org.jzy3d.colors.Color;
import org.jzy3d.maths.Coord3d;
import org.jzy3d.plot3d.primitives.Scatter;
import org.jzy3d.plot3d.rendering.canvas.Quality;

import java.util.ArrayList;
import java.util.logging.Logger;



public class ScattorDraw extends AbstractAnalysis {
    public enum ColorCS {
        RED, GREEN, BLANK, ORANGE,BLUE,PINK,YELLOW,MAGENTA,lightGray
    }
    public static void main(String[] args) throws Exception {
        AnalysisLauncher.open(new ScattorDraw());
    }

    @Override
    public void init(){

        //获取数据库信息记录
        ArrayList<SampleData> sampleData=new DataUtil().queryTable("tb1");
        Logger logger=Logger.getLogger ("createDataset");
        int size=sampleData.size();
        logger.info("长度:"+String.valueOf(size));
        Coord3d[] points = new Coord3d[size];
        Color[]   colors = new Color[size];
        int i=0;
        float a;
        for (SampleData temp:sampleData
             ) {

            points[i]=new Coord3d((float)Math.ceil(i/10.0f),temp.getmY(),temp.getmZ());
            a = 0.25f;
            colors[i]=Color.RED.clone();
           // colors[i] = new Color(255,255,255);
            i=i+1;
        }

        logger.info("bynow");
        Scatter scatter = new Scatter(points, colors);
        chart = AWTChartComponentFactory.chart(Quality.Advanced, "newt");
        chart.getAxeLayout().setMainColor(Color.WHITE);
        chart.getView().setBackgroundColor(Color.BLACK);
        chart.getScene().add(scatter);
    }
}
