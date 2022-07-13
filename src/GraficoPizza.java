import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.JFrame;
public class GraficoPizza extends JFrame{
	public void GraficoPizzas(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Gráfico Pizza");
		setSize(950,700);
		setLocationRelativeTo(null);
		
		criarGraficoPizza();
		
		setVisible(true);

	}
	public void criarGraficoPizza() {
		DefaultPieDataset pizza = new DefaultPieDataset();
		pizza.setValue("Matriz", 500);
		pizza.setValue("Larga",400);
		pizza.setValue("Itália", 450);
		pizza.setValue("Verde", 250);

		
		JFreeChart graficopizza=ChartFactory.createPieChart("Consumo por Rua- Julho 2022", pizza,true,true,false);	
		ChartPanel painel = new ChartPanel(graficopizza);
		add(painel);
	}a
	
}
