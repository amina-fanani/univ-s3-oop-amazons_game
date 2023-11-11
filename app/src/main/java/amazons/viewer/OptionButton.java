package amazons.viewer;

import amazons.util.ImageUtil;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class OptionButton extends Label {

    private final ImageView icon;

    public OptionButton(String imageResource,  String tooltip) {
        setAlignment(Pos.CENTER);
        icon = new ImageView(ImageUtil.loadImage(imageResource, 40, 40));
        resizeIcon(30);
        setGraphic(icon);
        setOnMouseEntered(this::onMouseEntered);
        setOnMouseExited(this::onMouseExited);
        setMinHeight(35);
        setMaxHeight(35);
        setMinWidth(40);
        setMaxWidth(40);
        setTooltip(new Tooltip(tooltip));
    }
    public OptionButton(String imageResource, EventHandler<? super MouseEvent> mouseClickedEvent, String tooltip) {
        this(imageResource, tooltip);
        setOnMouseClicked(mouseClickedEvent);
    }

    private void onMouseEntered(MouseEvent e) {
        resizeIcon(35);
        e.consume();
    }

    private void onMouseExited(MouseEvent e) {
        resizeIcon(30);
        e.consume();
    }

    private void resizeIcon(int width) {
        icon.setPreserveRatio(true);
        icon.setFitWidth(width);
    }
}
