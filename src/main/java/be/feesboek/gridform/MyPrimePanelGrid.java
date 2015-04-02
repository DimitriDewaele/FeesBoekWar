package be.feesboek.gridform;

import org.primefaces.component.panelgrid.PanelGrid;

public class MyPrimePanelGrid {

    private MyPrimePanelGrid() {
    }

    /**
     * Create a PanelGrid with x columns
     *
     * @return PanelGroup
     */
    public static PanelGrid generateResponsive(int columns) {

        PanelGrid panelGrid = new PanelGrid();
        panelGrid.setColumns(columns);

        return panelGrid;
    }

    public static PanelGrid generateResponsiveWithId(int columns, String id) {

        PanelGrid panelGrid = new PanelGrid();
        panelGrid.setColumns(columns);
        panelGrid.setId(id);

        return panelGrid;
    }
}
