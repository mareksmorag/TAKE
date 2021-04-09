/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.backing;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author Guest
 */
@Named(value = "chartBean")
@RequestScoped
public class ChartBean {
    private LineChartModel lineChartModel;

    /**
     * Creates a new instance of ChartBean
     */
    public ChartBean() {
        this.lineChartModel = createLineModel();
        this.lineChartModel.setZoom(true);
    }
    
    private LineChartModel createLineModel(){
        LineChartModel model = new LineChartModel();
        
        LineChartSeries series = new LineChartSeries();
        series.setLabel("sin(x)");
        for (int i = 0; i <= 360; i += 10) {
            double radians = Math.toRadians(i);
            series.set(i, Math.sin(radians));
        }
        
        
        
        model.addSeries(series);
        return model;
        
    }

    /**
     * @return the lineChartModel
     */
    public LineChartModel getLineChartModel() {
        return lineChartModel;
    }

    /**
     * @param lineChartModel the lineChartModel to set
     */
    public void setLineChartModel(LineChartModel lineChartModel) {
        this.lineChartModel = lineChartModel;
    }
    
}
