package org.timaofx.players;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaViewBuilder;
import javafx.util.Duration;

public class TocadorVideo extends StackPane {

	private Button btnTocarParar;
	private MediaPlayer tocadorVideo;

	public TocadorVideo(String caminhoVideo) {
		tocadorVideo = new MediaPlayer(new Media(caminhoVideo));
		btnTocarParar = new Button("Tocar");
		getChildren().addAll(
				MediaViewBuilder.create().fitHeight(250).fitWidth(280)
						.mediaPlayer(tocadorVideo).build(), btnTocarParar);

		btnTocarParar.visibleProperty().bind(this.hoverProperty());
		btnTocarParar.setOpacity(0.5);
		btnTocarParar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				if (tocadorVideo.getCurrentTime().greaterThan(new Duration(0))) {
					tocadorVideo.stop();
					btnTocarParar.setText("Tocar");
				} else {
					tocadorVideo.play();
					btnTocarParar.setText("Parar");
				}
			}
		});
	}
}
