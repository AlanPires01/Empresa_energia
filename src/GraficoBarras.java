
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraficoBarras extends JFrame {
	public void GraficoBarra() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Gráfico de Barras");
		setSize(950,700);
		setLocationRelativeTo(null);
		criarGrafico();
		setVisible(true);
	}
	
	public void criarGrafico() {
		DefaultCategoryDataset barra = new DefaultCategoryDataset();
		barra.setValue(500,"Matriz","");
		barra.setValue(400,"Larga","");
		barra.setValue(450,"Itália","");
		barra.setValue(250,"Verde","");
		
		JFreeChart graficobarras=ChartFactory.createBarChart("A", "B","C",barra,PlotOrientation.VERTICAL,true,true,false);	
		ChartPanel painel = new ChartPanel(graficobarras);
		add(painel);
	}
}
