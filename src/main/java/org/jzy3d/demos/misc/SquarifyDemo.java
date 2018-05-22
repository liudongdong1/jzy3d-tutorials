package org.jzy3d.demos.misc;

import org.jzy3d.analysis.AbstractAnalysis;
import org.jzy3d.analysis.AnalysisLauncher;
import org.jzy3d.chart.factories.AWTChartComponentFactory;
import org.jzy3d.colors.Color;
import org.jzy3d.colors.ColorMapper;
import org.jzy3d.colors.colormaps.ColorMapRainbow;
import org.jzy3d.maths.Range;
import org.jzy3d.plot3d.builder.Builder;
import org.jzy3d.plot3d.builder.Mapper;
import org.jzy3d.plot3d.builder.concrete.OrthonormalGrid;
import org.jzy3d.plot3d.primitives.Shape;
import org.jzy3d.plot3d.rendering.canvas.Quality;
import org.jzy3d.plot3d.transform.squarifier.XZSquarifier;

public class SquarifyDemo extends AbstractAnalysis {
    public static void main(String[] args) throws Exception {
        AnalysisLauncher.open(new SquarifyDemo());
    }

    @Override
    public void init() {
        // Define a function to plot
        Mapper mapper = new Mapper() {
            @Override
            public double f(double x, double y) {
                return x * Math.sin(x * y) *10;
            }
        };

        // Define range and precision for the function to plot
        Range range = new Range(-2.5f, 2.5f);
        int steps = 80;
        Range yrange = new Range(-5, 5);

        // Create the object to represent the function over the given range.
        final Shape surface = Builder.buildOrthonormal(new OrthonormalGrid(range, steps, yrange, steps), mapper);
        surface.setColorMapper(new ColorMapper(new ColorMapRainbow(), surface.getBounds().getZmin(), surface.getBounds().getZmax(), new Color(1, 1, 1, .5f)));
        surface.setFaceDisplayed(true);
        surface.setWireframeDisplayed(false);

        // Create a chart
        chart = AWTChartComponentFactory.chart(Quality.Intermediate, getCanvasType());
        
        //This addition keeps the aspect ratio of the X and Y data
        //but makes X and Z square
        chart.getView().setSquarifier(new XZSquarifier());
        chart.getView().setSquared(true);
        chart.getScene().getGraph().add(surface);
    }
}
