package com.mySampleApplication.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.DOM;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class MySampleApplication implements EntryPoint {

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        final Button button = new Button("Click me");
        final Label label = new Label();

        // image 1
        Image image1 = new Image();
        image1.setUrl(GWT.getModuleBaseURL()+"udvma.png");
        image1.setWidth("100px");
        VerticalPanel panel1 = new VerticalPanel();
        //HorizontalPanel panel1 = new HorizontalPanel();
        panel1.add(image1);
        RootPanel.get("image1").add(panel1);

        // image 2
        Image image2 = new Image();
        image2.setUrl(GWT.getModuleBaseURL()+"history.png");
        image2.setWidth("150px");
        image2.setHeight("100px");
        VerticalPanel panel2 = new VerticalPanel();
        //HorizontalPanel panel2 = new HorizontalPanel();
        panel2.add(image2);
        RootPanel.get("image2").add(panel2);

        // image 3
        Image image3 = new Image();
        image3.setUrl(GWT.getModuleBaseURL()+"udvma.png");
        image3.setWidth("100px");
        VerticalPanel panel3 = new VerticalPanel();
        //HorizontalPanel panel1 = new HorizontalPanel();
        panel3.add(image3);
        RootPanel.get("image3").add(panel3);







        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                if (label.getText().equals("")) {
                    MySampleApplicationService.App.getInstance().getMessage("Hello, World!", new MyAsyncCallback(label));
                } else {
                    label.setText("");
                }
            }
        });

        // Assume that the host HTML has elements defined whose
        // IDs are "slot1", "slot2".  In a real app, you probably would not want
        // to hard-code IDs.  Instead, you could, for example, search for all
        // elements with a particular CSS class and replace them with widgets.
        //
        RootPanel.get("slot1").add(button);
        RootPanel.get("slot2").add(label);
    }

    private static class MyAsyncCallback implements AsyncCallback<String> {
        private Label label;

        public MyAsyncCallback(Label label) {
            this.label = label;
        }

        public void onSuccess(String result) {
            label.getElement().setInnerHTML(result);
        }

        public void onFailure(Throwable throwable) {
            label.setText("Failed to receive answer from server!");
        }
    }
}
