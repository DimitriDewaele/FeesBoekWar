package be.feesboek.gridform;

import javax.faces.component.html.HtmlPanelGroup;

public final class MyPanelGroup {

    private MyPanelGroup() {
    }

    /**
     * Create a PanelGroup with a DIV
     *
     * @return PanelGroup
     */
    public static HtmlPanelGroup generateResponsive() {

        HtmlPanelGroup panelGroup = new HtmlPanelGroup();
        panelGroup.setLayout("block");

        return panelGroup;
    }
}
