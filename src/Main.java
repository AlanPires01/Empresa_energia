

import GraficoBarras;
import GraficoPizza;
import javax.swing.JFrame;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.BasicStroke;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.data.general.DefaultPieDataset;

import org.jfree.chart.demo.BarChartDemo1;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

public class Main extends JFrame{
	
		
	
	public static void main(String[] args) {
	

		//GraficoBarras teste = new GraficoBarras();
		//teste.GraficoBarra();
		GraficoPizza teste2 = new GraficoPizza();
		teste2.GraficoPizzas();
		
		var janeiro = new XYSeries("Consumo Janeiro");
		var fevereiro = new XYSeries("Consumo Fevereiro");
		try {
			FileReader fr = new FileReader("C:\\Users\\alanp\\eclipse-workspace\\Empresa\\arquivos\\dados.csv");
			BufferedReader bf = new BufferedReader (fr);
			String linha=bf.readLine();
			System.out.println(linha);
			int contador=1;
			linha=bf.readLine();
			linha=bf.readLine();

			while(contador<=20) {
				String[] dados = linha.split(","); 
				if(dados.length>=8) {
					janeiro.add(contador,Integer.parseInt(dados[5]));
					fevereiro.add(contador,Integer.parseInt(dados[6]));
					System.out.println(dados[5]);
					System.out.println(dados[6]);
				}
				linha=bf.readLine();
				//System.out.println(linha);
				contador++;
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Diretório de trabalho"+ System.getProperty("user.dir"));
		}
		
		var dataset=new XYSeriesCollection();
		dataset.addSeries(janeiro);
		dataset.addSeries(fevereiro);
		
		JFreeChart chart = ChartFactory.createXYLineChart(
				"Comparitivo de consumo Janeiro e Fevereiro",
				"Evolução do consumo",
				"Quantidade de Kw",
				dataset,
				PlotOrientation.VERTICAL,
				true,
				true,
				false
		);
		
		XYPlot plot = chart.getXYPlot();
		var renderer = new XYLineAndShapeRenderer();
		
		  renderer.setSeriesPaint(0, Color.RED);
	        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
	        renderer.setSeriesPaint(1, Color.BLUE);
	        renderer.setSeriesStroke(1, new BasicStroke(2.0f));

	        plot.setRenderer(renderer);
	        plot.setBackgroundPaint(Color.white);
	        plot.setRangeGridlinesVisible(false);
	        plot.setDomainGridlinesVisible(false);

	        chart.getLegend().setFrame(BlockBorder.NONE);

	        ChartFrame frame1 = new ChartFrame("Gráfico de linhas", chart);
	    //    frame1.setVisible(true);
	     //   frame1.setSize(1300, 800);
	}
}

