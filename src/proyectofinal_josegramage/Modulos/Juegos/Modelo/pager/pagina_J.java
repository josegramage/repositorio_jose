package proyectofinal_josegramage.Modulos.Juegos.Modelo.pager;
import proyectofinal_josegramage.Modulos.Juegos.Clases.SimpleTableModel_juegos;
import proyectofinal_josegramage.Librerias.Singletons;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JRadioButton;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import proyectofinal_josegramage.Modulos.Juegos.Vista.Vtna_jue_Pager;



public class pagina_J {
    public static final LinkViewRadioButtonUI_J ui = new LinkViewRadioButtonUI_J();
    public static int LR_PAGE_SIZE = 5;
    public static Box box = Box.createHorizontalBox();

    public static int currentPageIndex = 1;
    public static int itemsPerPage = 5;
    public static int maxPageIndex;

    public static void inicializa() {
        int rowCount = 0;

        rowCount = ((SimpleTableModel_juegos)Vtna_jue_Pager.TABLA.getModel()).getRowCount();
   
        
        int v = rowCount%itemsPerPage==0 ? 0 : 1;
        maxPageIndex = rowCount/itemsPerPage + v;
        
        box.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));

                    Vtna_jue_Pager.jPanel4.setLayout(new BorderLayout());
                    Vtna_jue_Pager.jPanel4.add(pagina_J.box);
    }
    
    public static void initLinkBox() {
 
                    Singletons.sorter.setRowFilter(new RowFilter<TableModel, Integer>() {
                        @Override public boolean include(RowFilter.Entry<? extends TableModel, ? extends Integer> entry) {
                            int ti = currentPageIndex - 1;
                            int ei = entry.getIdentifier();
                            return ti*itemsPerPage<=ei && ei<ti*itemsPerPage+itemsPerPage;
                        }
                    });


        int startPageIndex = currentPageIndex-LR_PAGE_SIZE;
        int endPageIndex = 0;
        if(startPageIndex<=0) { startPageIndex = 1; }

        int rowCount = 0;

                rowCount = ((SimpleTableModel_juegos)Vtna_jue_Pager.TABLA.getModel()).getRowCount();


        int v = rowCount%itemsPerPage==0 ? 0 : 1;
        maxPageIndex = rowCount/itemsPerPage + v;
        endPageIndex = currentPageIndex+LR_PAGE_SIZE-1;
        if(endPageIndex>maxPageIndex) {
            endPageIndex = maxPageIndex;
        }

        box.removeAll();
        if(  (rowCount<=itemsPerPage) && (rowCount>0)  ){ //caben todos los datos en la misma página

                //actualizar botones y caja: desactivarlos
                Vtna_jue_Pager.primero.setEnabled(false);
                Vtna_jue_Pager.ANTERIOR.setEnabled(false);
                Vtna_jue_Pager.SIGUIENTE.setEnabled(false);
                Vtna_jue_Pager.ultimo.setEnabled(false);
                Vtna_jue_Pager.CAJA.setText("");

            //actualizar enlaces: sólo 1 enlace
            ButtonGroup bg = new ButtonGroup();
            box.add(Box.createHorizontalGlue());
            JRadioButton c = makeRadioButton(1);
            box.add(c);
            bg.add(c);
            box.add(Box.createHorizontalGlue());
            box.revalidate();
            box.repaint();
            
        }else if(rowCount==0) { //no hay rdos

                //actualizar botones y caja: desactivarlos
                Vtna_jue_Pager.primero.setEnabled(false);
                Vtna_jue_Pager.ANTERIOR.setEnabled(false);
                Vtna_jue_Pager.SIGUIENTE.setEnabled(false);
                Vtna_jue_Pager.ultimo.setEnabled(false);
                Vtna_jue_Pager.CAJA.setText("");

            //actualizar enlaces: no hay enlaces
            ButtonGroup bg = new ButtonGroup();
            box.add(Box.createHorizontalGlue());
            JRadioButton c = makeRadioButton(0);
            box.add(c);
            bg.add(c);
            box.add(Box.createHorizontalGlue());
            box.revalidate();
            box.repaint();
            
        }else if(rowCount>itemsPerPage) {

                    Vtna_jue_Pager.primero.setEnabled(currentPageIndex>1);
                    Vtna_jue_Pager.ANTERIOR.setEnabled(currentPageIndex>1);
                    Vtna_jue_Pager.SIGUIENTE.setEnabled(currentPageIndex<maxPageIndex);
                    Vtna_jue_Pager.ultimo.setEnabled(currentPageIndex<maxPageIndex);
                    Vtna_jue_Pager.CAJA.setText(Integer.toString(currentPageIndex) + String.format(" / %d", maxPageIndex));

            ButtonGroup bg = new ButtonGroup();
            box.add(Box.createHorizontalGlue());
            for(int i=startPageIndex;i<=endPageIndex;i++) {
                JRadioButton c = makeRadioButton(i);
                box.add(c);
                bg.add(c);
            }
            box.add(Box.createHorizontalGlue());
            box.revalidate();
            box.repaint();
        }
    }
    public static JRadioButton makeRadioButton(final int target) {
        JRadioButton radio = new JRadioButton(String.valueOf(target)) {
            @Override protected void fireStateChanged() {
                ButtonModel model1 = getModel();
                if(!model1.isEnabled()) {
                    setForeground(Color.GRAY);
                }else if(model1.isPressed() && model1.isArmed()) {
                    setForeground(Color.GREEN);
                }else if(model1.isSelected()) {
                    setForeground(Color.RED);
                }
                super.fireStateChanged();
            }
        };
        radio.setForeground(Color.BLUE);
        radio.setUI(ui);
        if(target==currentPageIndex) {
            radio.setSelected(true);
        }
        radio.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                currentPageIndex=target;
                initLinkBox();
            }
        });
        return radio;
    }
}
