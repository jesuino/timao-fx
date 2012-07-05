package org.timaofx.players;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;

public class TocadorAudio extends Button implements EventHandler<ActionEvent> {
	AudioClip audio;
	public TocadorAudio(String arquivo) {
		super("Tocar");
		audio = new AudioClip(arquivo);
		this.setOnAction(this);
	}
	@Override
	public void handle(ActionEvent e) {
		if (audio.isPlaying()) {
			audio.stop();
			setText("Tocar");
		} else {
			audio.play();
			setText("Parar");
		}
	}
}