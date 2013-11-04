package org.timaofx.main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPaneBuilder;
import javafx.scene.control.TitledPane;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.GridPaneBuilder;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;
import javafx.stage.Stage;

import org.timaofx.players.TocadorAudio;
import org.timaofx.players.TocadorVideo;

public class Principal extends Application {

	private final String URL_SIMBOLO = getClass().getResource(
			"/recursos/imagem/corinthians-4.gif").toString();

	private final String AUDIO_HINO = getClass().getResource(
			"/recursos/audio/hino-corinthians.mp3").toString();
	private final String AUDIO_HINO_ROCK = getClass().getResource(
			"/recursos/audio/rock-hino-corinthians.mp3").toString();
	private final String AUDIO_HINO_GAVIOES = getClass().getResource(
			"/recursos/audio/gavioes-hino-corinthians.mp3").toString();

	private final String VIDEO_MARCELINHO = getClass().getResource(
			"/recursos/video/gol-marcelinho-reportagem.mp4").toString();
	private final String VIDEO_POVO = getClass().getResource(
			"/recursos/video/corinthians-time-povo.mp4").toString();
	private final String VIDEO_GOL_VIOLA = getClass().getResource(
			"/recursos/video/gol-viola.mp4").toString();

	private final String ARQUIVO_CSS = getClass().getResource(
			"/recursos/css/estilo.css").toString();

	private final String[] TITULOS = { "Copa do Mundo de Clubes da FIFA (2)",
			"Campeonato Brasileiro (5)", "Copa do Brasil (3)",
			"Supercopa do Brasil (1)", "Campeonato Brasileiro - S�rie B (1)",
<<<<<<< HEAD
			"Torneio Rio-S�o Paulo (5)", "Campeonato Paulista (26)",
			"Libertadores da Am�rica (?) SER� HOJE???" };
=======
			"Torneio Rio-S�o Paulo (5)", "Campeonato Paulista (27)",
			"Libertadores da Am�rica (1)", "Recopa sul-americana(1)"};
>>>>>>> 8266fa3f548fe072a2f32951a20d99132165f5b9

	private final String INFO = "O Sport Club Corinthians Paulista foi fundado em 1� de setembro de 1910. A equipe � a maior campe� da hist�ria do Campeonato Paulista, com 26 ta�as.";

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage palco) throws Exception {
		BorderPane raiz = new BorderPane();
		Scene cena = new Scene(raiz, 400, 500);

		Accordion paineis = new Accordion();
		paineis.getPanes().addAll(
				new TitledPane("Informa��es Gerais", fazerPainelInfo()),
				new TitledPane("Videos", fazerPainelVideos()),
				new TitledPane("Hinos", fazerPainelHinos()),
				new TitledPane("T�tulos", fazerPainelTitulos()));
		paineis.setExpandedPane(paineis.getPanes().get(0));
		raiz.setTop(fazerTitulo());
		BorderPane.setMargin(raiz.getTop(), new Insets(20));
		raiz.setCenter(paineis);
		cena.getStylesheets().add(ARQUIVO_CSS);
		cena.setFill(Color.BLACK);
		palco.setScene(cena);
		palco.setTitle("� Hoje, Vai Tim�o!!!!");
		palco.setResizable(false);
		palco.show();
	}

	private Label fazerTitulo() {
		Label lblTitulo = new Label("Sport Club Corinthians Paulista");
		lblTitulo.setFont(new Font("Arial Black", 21));
		lblTitulo.setTextFill(Color.WHITE);
		Reflection efeitoReflexao = new Reflection();
		efeitoReflexao.setFraction(0.7);
		lblTitulo.setEffect(efeitoReflexao);
		return lblTitulo;
	}

	private Pane fazerPainelInfo() {
		ImageView imgSimbolo = ImageViewBuilder.create()
				.image(new Image(URL_SIMBOLO)).fitHeight(340).fitWidth(400)
				.opacity(0.4).build();
		Text txtInfo = TextBuilder.create().text(INFO).wrappingWidth(390)
				.styleClass("txtInfo").build();
		StackPane painelSimbolo = new StackPane();
		painelSimbolo.getChildren().addAll(imgSimbolo, txtInfo);
		return painelSimbolo;
	}

	private Node fazerPainelVideos() {
		VBox caixaVideos = new VBox(10);
		caixaVideos.getChildren().addAll(new TocadorVideo(VIDEO_POVO),
				new TocadorVideo(VIDEO_GOL_VIOLA),
				new TocadorVideo(VIDEO_MARCELINHO));
		caixaVideos.setAlignment(Pos.CENTER);
		caixaVideos.setFillWidth(true);
		return ScrollPaneBuilder.create().content(caixaVideos).fitToWidth(true)
				.build();
	}

	private Pane fazerPainelHinos() {
		GridPane pnlHinos = GridPaneBuilder.create().translateX(80)
				.translateY(90).hgap(20).vgap(30).build();
		pnlHinos.add(new Text("Hino Original"), 0, 0);
		pnlHinos.add(new TocadorAudio(AUDIO_HINO), 1, 0);
		pnlHinos.add(new Text("Hino Vers�o Rock"), 0, 1);
		pnlHinos.add(new TocadorAudio(AUDIO_HINO_ROCK), 1, 1);
		pnlHinos.add(new Text("Hino Gavi�es da Fiel"), 0, 2);
		pnlHinos.add(new TocadorAudio(AUDIO_HINO_GAVIOES), 1, 2);
		return pnlHinos;
	}

	private Pane fazerPainelTitulos() {
		ListView<String> listaTitulos = new ListView<String>();
		listaTitulos.getItems().addAll(TITULOS);
		StackPane pnlItems = new StackPane();
		pnlItems.getChildren().addAll(listaTitulos);
		return pnlItems;
	}
}
