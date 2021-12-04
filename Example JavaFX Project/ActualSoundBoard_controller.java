import java.awt.Desktop;
import java.awt.Desktop.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javafx.animation.*;
import javafx.application.Application;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.media.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.*;
import javafx.stage.FileChooser.*;
import javafx.util.*;
import javax.sound.sampled.*;


public class ActualSoundBoard_controller extends Application{
	public static String[] musicNames = new String[28];
	
	public static String[] bandNames = new String[musicNames.length];
	
	public static int[] que = new int[28];
	
	public static int[] effectSpeeds = new int[27];
	public static int[] effectSoundVolume = new int[27];
	
	public static int[] settings = new int[3];
	
	public static Media media;
	public static MediaPlayer mediaPlayer;
	
	public static File directory = new File("musicPlayer");;
	public static File[] files;
	
	public static ArrayList<File> songs = new ArrayList<File>();
	
	public static Media media_2;
	public static MediaPlayer mediaPlayer_2;
	
	public static File directory2 = new File("soundsForSoundBoard");;
	public static File[] files2;
	
	public static ArrayList<File> sounds = new ArrayList<File>();
	@FXML
	public Label speedLabel;
	@FXML
	public Label musicVolume;
	@FXML
	public Label speedLabel2;
	@FXML
	public Label soundVolume;
	@FXML
	public Label EchoAmount;
	@FXML
	public Label EchoVolume;
	@FXML
	public Label cycleCountLabel;
	@FXML
	public Label musicBalanceLabel;
	@FXML
	public Label effectBalanceLabel;
	@FXML
	public Label volumeInfo;
	@FXML
	public Label muteOnOrOff;
	@FXML
	public Label musicSpeed;
	@FXML
	public Label musicPlaying;
	@FXML
	public Label shuffleLabel;
	@FXML
	public Label titleLabel;
	@FXML
	public Label titleLabel2;

	public static Clip effectEffects_1;
	
	public static int musicTracker = 0;
	
	public boolean timerExist = false;
	
	public boolean music = true;
	
	public boolean running1 = false;
	
	public static boolean running = false;
	
	public static boolean shuffleOnOrOff = false;
	
	public Timer timer;
	
	public TimerTask task;
	
	public Timer Echo;
	
	public TimerTask EchoTask;
	@FXML
	public ProgressBar songProgressBar;
	
	public static Scanner method= new Scanner(System.in);
	
	public static int songTracker;
	
	public static int songPlay ;
	
	public static int songQue;
	
	public static int queMaker;
	
	public static int song;
	
	public static String[] args2;
	
	public static int rando;
	
	public double balance = 0.0;
	public double balance2 = 0.0;
	
	public static int play;
	public int cycleCount = 1;
	
	public int loop = 0;
	public int loopCycle = 0;
	
	public int speed = 100;
	public int volume = 50;
	public int speed2 = 100;
	public int volume2 = 50;
	public boolean muteOrNot = false; 
	
	public static int effectSound;

	public boolean isShuffleOn = false;
	public boolean loopExist = false;
	public boolean runningLoop = false;
	
//+----------------------------------------------------------------------------+
//	Everything past here are controls for sound board
	
	private int var;

    public void ActualSoundBoard_controller(int var) {
        this.var = var;
    }

    public void run() {
        // code in the other thread, can reference "var" variable
        main(new String[0]);
    }
	
	
	public static void main(String[]args){
		args2 = args;
		songTracker = 0;
		effectSound = 0;
		
		musicNames[0] = "Beat Broken Scarred";
		musicNames[1] = "Brandy";
		musicNames[2] = "Cant";
		musicNames[3] = "Tequilla";
		musicNames[4] = "Enter Sandman";
		musicNames[5] = "Fortunes Son";
		musicNames[6] = "For Whome The Bell Tolls";
		musicNames[7] = "Green Face";
		musicNames[8] = "The Horse With No Name";
		musicNames[9] = "House Of The Rising Sun";
		musicNames[10]= "Two Sides To Every Story";
		musicNames[11]= "Lifes Been Good So Far";
		musicNames[12]= "Jump On It (Apache)";
		musicNames[13]= "La Grange";
		musicNames[14]= "Last Day Under The Sun";
		musicNames[15]= "Long As I Can See The Light";
		musicNames[16]= "Low Rider";
		musicNames[17]= "Man On The Silver Mountain";
		musicNames[18]= "Rocket Man";
		musicNames[19]= "Seak and Destroy";
		musicNames[20]= "Smoke On The Water";
		musicNames[21]= "Souther Nights";
		musicNames[22]= "Space Oddity";
		musicNames[23]= "The Four Horse Men";
		musicNames[24]= "Walk";
		musicNames[25]= "Warriors call";
		musicNames[26]= "Wish You Were Here";
		musicNames[27]= "Working Man";
		
		
		bandNames[0] = "Metallica";
		bandNames[1] = "Looking glass";
		bandNames[2] = "McHammer";
		bandNames[3] = "Champs";
		bandNames[4] = "Metallica";
		bandNames[5] = "Creedence Clearwater Revival";
		bandNames[6] = "Metallica";
		bandNames[7] = "Iced Earth";
		bandNames[8] = "America";
		bandNames[9] = "The Animals";
		bandNames[10]= "Jow Walsh";
		bandNames[11]= "Joe Walsh";
		bandNames[12]= "Old People";
		bandNames[13]= "ZZ Top";
		bandNames[14]= "Volbeat";
		bandNames[15]= "Creedence ClearWater Revival";
		bandNames[16]= "War";
		bandNames[17]= "RainBow";
		bandNames[18]= "Elthon John";
		bandNames[19]= "Metallica";
		bandNames[20]= "Deep Purple";
		bandNames[21]= "Glen Cambell";
		bandNames[22]= "David Bowie";
		bandNames[23]= "Metallica";
		bandNames[24]= "Pantera";
		bandNames[25]= "Volbeat";
		bandNames[26]= "Pink Floyd";
		bandNames[27]= "Rush";
		

		
		//try {
            ////Process p = Runtime.getRuntime().exec("xterm");
            //BufferedWriter w = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));

            //w.write("ls");
            //w.flush();
            ////w.close();

            //BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));

            //String s;
            //while ((s = r.readLine()) != null) {
                //System.out.println(s);
            //}
        //}
        //catch (IOException io) {
            //io.printStackTrace();
        //}


		files = directory.listFiles();
		int i = 0;
		if(files != null){
			for(File file : files){
				songs.add(file);
				
				System.out.println(songs.get(i));
				i++;
			}
		}
		
		
		
		
		media = new Media(songs.get(songTracker).toURI().toString());
		
		mediaPlayer = new MediaPlayer(media);
		
		files2 = directory2.listFiles();
		int z = 0;
		if(files2 != null){
			for(File file : files2){
				sounds.add(file);
				
				System.out.println(sounds.get(z));
				z++;
			}
		}
		
		media_2 = new Media(sounds.get(que[effectSound]).toURI().toString());
		
		mediaPlayer_2 = new MediaPlayer(media_2);
		
		//for(int speedLoop = 0; speedLoop < speeds.length; speedLoop++){
			
			//speedBox.getItems().add(Integer.toString(speeds[speedLoop]) + "%");
			
		//}
		
		for(int effectVolumeLoop = 0; effectVolumeLoop < effectSoundVolume.length - 1; effectVolumeLoop++){
			effectSoundVolume[effectVolumeLoop] = 50;
		}
		for(int effectSpeedsLoop = 0; effectSpeedsLoop < effectSpeeds.length - 1; effectSpeedsLoop++){
			effectSpeeds[effectSpeedsLoop] = 100;
		}
		//mediaPlayer.setOnEndOfMedia(updateSong());
		
		
		launch(args);
		
		
	}
	
	
	public void start(Stage stage) throws Exception { //Gui stuff for stage
		
		Parent root = FXMLLoader.load(getClass().getResource("ActualSoundBoard.fxml"));
		stage.setTitle("SoundBoard");
		stage.setScene(new Scene(root));
		stage.show();

		stage.show();
		
		
	}
//These are all the music contol buttons
//+-------------------------------------+
	public void unSetText(ActionEvent e){
		titleLabel.setText("");
		titleLabel2.setText("");
	}
	
	public void setText(ActionEvent e){
		titleLabel.setText(musicNames[que[musicTracker]]);
		titleLabel2.setText(bandNames[que[musicTracker]]);
	}
	
	public void info(ActionEvent e){
		System.out.println(mediaPlayer.getAudioEqualizer().toString());
		System.out.println(mediaPlayer.getAudioSpectrumThreshold());
		//System.out.println(mediaPlayer.getAudioEqualizer());
		
		System.out.println(mediaPlayer.getAudioSpectrumNumBands());
	}
	
	public void Mute(ActionEvent e){
		mediaPlayer.setMute(true);
		muteOrNot = true;
		muteOnOrOff.setText("Mute On");
	}
	
	public void unMute (ActionEvent e){
		mediaPlayer.setMute(false);
		muteOrNot = false;
		muteOnOrOff.setText("Mute Off");
	}
	
	public void load(ActionEvent e)throws FileNotFoundException{
		int h = 0;
		File effectVolumeLoad = new File("effectsSoundVolume.txt");
		Scanner effectVolumeScanner = new Scanner(effectVolumeLoad);
		if(effectVolumeLoad.exists()){
			while(effectVolumeScanner.hasNextInt()){
				effectSoundVolume[h] = effectVolumeScanner.nextInt();
				h++;
			}
		}
		h = 0;
		File effectSpeedsLoad = new File("effectsSpeeds.txt");
		Scanner effectSpeedsScanner = new Scanner(effectSpeedsLoad);
		if(effectSpeedsLoad.exists()){
			while(effectSpeedsScanner.hasNextInt()){
				effectSpeeds[h] = effectSpeedsScanner.nextInt();
				h++;
			}
		}
		h = 0;
		File settingsFile = new File("soundBoard.txt");
		Scanner settingsScanner = new Scanner(settingsFile);
		if(settingsFile.exists()){
			while(settingsScanner.hasNextInt()){
				settings[h] = settingsScanner.nextInt();
				h++;
				//settings[h] = settingsScanner.nextInt();
				//volume = settings[h];
				//h++;
				//settings[h] = settingsScanner.nextInt();
				//speed = settings[h];
				//h++;
				//settings[h] = settingsScanner.nextInt();
				//cycleCount = settings[h];
				//h++;

				//changeSpeed();
				//changeVolume();
				//setCycle();
				musicVolume.setText(Integer.toString(volume) + "%");
				speedLabel.setText(Integer.toString(speed) + "%");
				cycleCountLabel.setText(Integer.toString(cycleCount));

			}
			}
		}
	
	public void save(ActionEvent e){
		
		//System.out.println(Integer.toString(effectSoundVolume[0]));
		try{
		//File save = new File("effectsSoundVolume.txt");
		PrintStream out = new PrintStream(new File("effectsSoundVolume.txt"));
		//out = System.out;
		
			for(int h = 0; h < effectSoundVolume.length -1; h++){
				out.println(Integer.toString(effectSoundVolume[h]));
				
			}
		}
		catch(FileNotFoundException fnfe){
			System.out.println("lol");
		}
		try{
		//File save = new File("effectsSoundVolume.txt");
		PrintStream out = new PrintStream(new File("effectsSpeeds.txt"));
		//out = System.out;
		
			for(int h = 0; h < effectSpeeds.length; h++){
				out.println(Integer.toString(effectSpeeds[h]));
				
			// given family year grades.....
			}
		}
		catch(FileNotFoundException fnfe){
			System.out.println("lol");
		}
			try{
		//File save = new File("effectsSoundVolume.txt");
		PrintStream out = new PrintStream(new File("soundBoard.txt"));
		//out = System.out;
		
			for(int h = 0; h < settings.length; h++){
				out.println(Integer.toString(settings[h]));
				
			// given family year grades.....
			}
		}
		catch(FileNotFoundException fnfe){
			System.out.println("lol");
		}
			
	}
	
	public void balenceLeft(ActionEvent e){
		if(balance > -1.0){
			//balance = settingsDouble[2];
			balance = balance - .05;
			//settingsDouble[0] = balance;
			balanceSetter();
			musicBalanceLabel.setText(Double.toString(balance));
		}
	}
	
	public void balenceRight(ActionEvent e){
		if(balance < 1.0){
			//balance = settingsDouble[2];
			balance = balance + .05;
			//settingsDouble[0] = balance;
			balanceSetter();
			musicBalanceLabel.setText(Double.toString(balance));
		}
	}
	
	public void increaseVolume(ActionEvent e){
		if(volume < 100){
			volume = settings[0];
			volume = volume + 5;
			settings[0] = volume;
			changeVolume();
			musicVolume.setText(Integer.toString(volume) + "%");
			volumeInfo.setText("Volume: " + volume + "%");
		}
	}
	
	public void decreaseVolume(ActionEvent e){
		if(volume > 0){
			volume = settings[0];
			volume = volume - 5;
			settings[0] = volume;
			changeVolume();
			musicVolume.setText(Integer.toString(volume) + "%");
			volumeInfo.setText("Volume: " + volume + "%");
		}
	}
	
	public void increaseSpeed(ActionEvent e){
		if(speed < 200){
			speed = settings[1];
			speed = speed + 5;
			settings[1] = speed;
			changeSpeed();
			speedLabel.setText(Integer.toString(speed) + "%");
			musicSpeed.setText("Speed: " + speed + "%");
		}
	
	}
	
	public void decreaseSpeed(ActionEvent e){
		if(speed > 5){
			speed = settings[1];
			speed = speed - 5;
			settings[1] = speed;
			changeSpeed();
			speedLabel.setText(Integer.toString(speed) + "%");
			musicSpeed.setText("Speed: " + speed + "%");
		}
	}
	
	public void skipFoward(ActionEvent e){
		if(mediaPlayer.getCurrentTime().toSeconds() + 15 >= media.getDuration().toSeconds()){
			mediaPlayer.seek(Duration.seconds(media.getDuration().toSeconds()));
			next();
		}
		else{
			mediaPlayer.seek(Duration.seconds(mediaPlayer.getCurrentTime().toSeconds() + 15));
		}
	}
	
	public void rewind(ActionEvent e){
		if(mediaPlayer.getCurrentTime().toSeconds() - 15 <= 0){
			mediaPlayer.seek(Duration.seconds(media.getDuration().toSeconds()));
			previous(e);
		}
		else{
			mediaPlayer.seek(Duration.seconds(mediaPlayer.getCurrentTime().toSeconds() - 15000000));
		}
	}
	
	public void replay(ActionEvent e){
		songProgressBar.setProgress(0);
		mediaPlayer.seek(Duration.seconds(0));
	}
	
	public void stopButton(ActionEvent e){
		cancelTimer();
		mediaPlayer.pause();
		musicPlaying.setText("Not Playing");
	}
	
	public void playMusic(ActionEvent e){
		songProgressBar.setStyle("-fx-accent: #0cf200;");
		
		mediaPlayer.play();
		beginTimer();
		updater();
	}
	
	public void next(ActionEvent e){
		next();
	}
	
	public void next(){ // this isnt an extion event because the time wont be able to call it if i set it as one
		if(songTracker < songs.size() - 1){
			
			songTracker++;
			mediaPlayer.stop();
			if(shuffleOnOrOff == true){
				media = new Media(songs.get(que[songTracker]).toURI().toString());
				mediaPlayer = new MediaPlayer(media);
				System.out.println(songs.get(que[songTracker]));
			}
			if(shuffleOnOrOff == false){
				media = new Media(songs.get(songTracker).toURI().toString());
				mediaPlayer = new MediaPlayer(media);
				System.out.println(songs.get(songTracker));
			}
			mediaPlayer.play();
			mediaPlayer.setMute(muteOrNot);
			updater();
			
		}
		
		else{
			songTracker = 0;
			mediaPlayer.stop();
			
			if(shuffleOnOrOff == true){
				media = new Media(songs.get(que[songTracker]).toURI().toString());
				mediaPlayer = new MediaPlayer(media);
				System.out.println(songs.get(que[songTracker]));
			}
			if(shuffleOnOrOff == false){
				media = new Media(songs.get(songTracker).toURI().toString());
				mediaPlayer = new MediaPlayer(media);
				System.out.println(songs.get(songTracker));
			}
			mediaPlayer.play();
			
			updater();
			mediaPlayer.setMute(muteOrNot);
		}
		
	}
	
	public void previous(ActionEvent e){
		if(songTracker > 0){
			
			songTracker--;
			
			mediaPlayer.stop();
			
			if(shuffleOnOrOff == true){
				media = new Media(songs.get(que[songTracker]).toURI().toString());
				mediaPlayer = new MediaPlayer(media);
				System.out.println(songs.get(que[songTracker]));
			}
			if(shuffleOnOrOff == false){
				media = new Media(songs.get(songTracker).toURI().toString());
				mediaPlayer = new MediaPlayer(media);
				System.out.println(songs.get(songTracker));
			}
			
			mediaPlayer.play();
			updater();
			mediaPlayer.setMute(muteOrNot);
		}
		
		else{
			songTracker = songs.size() - 1;
			
			mediaPlayer.stop();
			
			if(shuffleOnOrOff == true){
				media = new Media(songs.get(que[songTracker]).toURI().toString());
				mediaPlayer = new MediaPlayer(media);
				System.out.println(songs.get(que[songTracker]));
			}
			if(shuffleOnOrOff == false){
				media = new Media(songs.get(songTracker).toURI().toString());
				mediaPlayer = new MediaPlayer(media);
				System.out.println(songs.get(songTracker));
			}
			
			mediaPlayer.play();
			updater();
			mediaPlayer.setMute(muteOrNot);
			
		}
		
	}
	
	public void shuffleButton(ActionEvent e){
		shuffleOnOrOff = true;
		randomQueMaker();
		mediaPlayer.setMute(muteOrNot);
		updater();
		
		for(int s = 0; s < que.length - 1; s++){
			System.out.println(que[s]);
		}
	}
	
	public void unShuffle(ActionEvent e){
		shuffleOnOrOff = false;
		updater();
	}
//+------------------------------------------+
	
	
//	These are the methods that control the music player
//+--------------------------------------------------------+
	//public updateSong(ActionEvent e){
		//if(shuffleOnOrOff == true){
			//currentSong.setText(songs.get(que[songTracker]).toString());
			//nextSong.setText(songs.get(que[songTracker +1]).toString());
		//}
		//if(shuffleOnOrOff == false){
			//currentSong.setText(songs.get(songTracker).toString());
			//currentSong.setText(songs.get(songTracker + 1).toString());
		//}
	//}
	public void changeSpeed(){
		
		
		//mediaPlayer.setRate(Integer.parseInt(speedBox.getValue().substring(0, speedBox.getValue().length() - 1))* 0.01);
		mediaPlayer.setRate(speed * 0.01);
		
	}
	
	public void changeVolume(){
		mediaPlayer.setVolume(volume * 0.01);
	}
	
	public void balanceSetter(){
		mediaPlayer.setBalance(balance);
	}
	
	public void updater(){
		balanceSetter();
		changeSpeed();
		changeVolume();
		musicVolume.setText(Integer.toString(volume) + "%");
		speedLabel.setText(Integer.toString(speed) + "%");
		musicPlaying.setText("Playing");
		shuffleLabel();
		
	}
	
	public void shuffleLabel(){
		if(shuffleOnOrOff == true){
			shuffleLabel.setText("Shuffle On");
		}
		else if(shuffleOnOrOff == false){
			shuffleLabel.setText("Shuffle Off");
		}
	}
	
	public void musicPlay(){
		
		if(running = true){
			mediaPlayer.stop();
		}
		
		media = new Media(songs.get(que[songTracker]).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		
		mediaPlayer.play();
		
		
		//System.out.println(musicPlay.getMicrosecondPosition());
		running = true;
		//musicTracker++;
	}
	
	public static void randomSong(){ // chooses a random song for the user
		int temp = rando;
		Random musicShuffle = new Random();
		
		while(temp == rando){
			rando = musicShuffle.nextInt(songs.size());
			musicTracker = rando;
			//System.out.println(musicNames[rando] + ": Song " + (rando + 1));
			
			
		}
		temp = rando;
		
		musicPlayer();
		
	}
	
	public static void musicPlayer(){//method that starts music
	
		if(songTracker != rando){
			if(running = true){
				mediaPlayer.stop();
			}
			
			media = new Media(songs.get(rando).toURI().toString());
			mediaPlayer = new MediaPlayer(media);
		
			mediaPlayer.play();
			
			
			songTracker = rando;
		
			
		}
		
		else if(songTracker == rando){
			System.out.println("Song is already playing");
		}
	}
	
	public void randomQueMaker(){  // makes a random que for the user 
		
		int rando = 0;
		Random musicShuffle = new Random();
		rando = musicShuffle.nextInt(songs.size() - 1);
		
		for(int i = 0; i < songs.size(); i++){
			if(i == 0){
				rando = musicShuffle.nextInt(songs.size() - 1);
			}
			
			for(int j = 0; j < i; j++){
				if(rando == que[j]){
					j = 0;
					rando = musicShuffle.nextInt(songs.size());
				}
			}
			
			if(i == songs.size() - 1){
				que[0] = rando;
			}
			
			else if(i == songs.size()){
			}
			
			else if(i != 0){
				que[i] = rando;
			}
			
			
			rando = musicShuffle.nextInt(songs.size());
				
		}
		for(int k = 0; k < songs.size() - 1; k++){
			//System.out.println(que[k]);
		}
		musicPlay();
	}
	
	public void beginTimer(){//use to call next song
		if(running1 == false){
			timerExist = true;
			timer = new Timer();
			//System.out.println("billy");
			task = new TimerTask(){
			
			
			public void run(){
				
				running1 = true;
				double current = mediaPlayer.getCurrentTime().toSeconds();
				double end = media.getDuration().toSeconds();
				
				System.out.println(current);
				songProgressBar.setProgress(current/end);
				
				
				
				if(current/end == 1){
					next();
					
					
					
					
				}
				
			}
				
			
			};
		timer.scheduleAtFixedRate(task, 1000, 1000);
		
		}
		}
	
	public void cancelTimer(){
		running1 = false;
		timer.cancel();
	}
//+------------------------------------------+
	
	
	
	
// Everything past here is effects controls.

//	These are all the sound effect buttons
//+-----------------------------------+
	public void BaDum(ActionEvent e){
		effectSound = 0;
		soundBoardPlayer();
	}
	public void bark(ActionEvent e){
		effectSound = 1;
		soundBoardPlayer();
	}
	public void CrowdRoar(ActionEvent e){
		effectSound = 2;
		soundBoardPlayer();
	}
	public void Denied(ActionEvent e){
		effectSound = 3;
		soundBoardPlayer();
	}
	public void fail(ActionEvent e){
		effectSound = 4;
		soundBoardPlayer();
	}
	public void finish(ActionEvent e){
		effectSound = 5;
		soundBoardPlayer();
	}
	public void fish(ActionEvent e){
		effectSound = 6;
		soundBoardPlayer();
	}
	public void glock(ActionEvent e){
		effectSound = 7;
		soundBoardPlayer();
	}
	public void ha(ActionEvent e){
		effectSound = 8;
		soundBoardPlayer();
	}
	public void horns(ActionEvent e){
		effectSound = 9;
		soundBoardPlayer();
	}
	public void Inception(ActionEvent e){
		effectSound = 10;
		soundBoardPlayer();
	}
	public void infinity(ActionEvent e){
		effectSound = 11;
		soundBoardPlayer();
	}
	public void johnCena(ActionEvent e){
		effectSound = 12;
		soundBoardPlayer();
	}
	public void kick(ActionEvent e){
		effectSound = 13;
		soundBoardPlayer();
	}
	public void laser(ActionEvent e){
		effectSound = 14;
		soundBoardPlayer();
	}
	public void leeroy(ActionEvent e){
		effectSound = 15;
		soundBoardPlayer();
	}
	public void moments(ActionEvent e){
		effectSound = 16;
		soundBoardPlayer();
	}
	public void nope(ActionEvent e){
		effectSound = 17;
		soundBoardPlayer();
	}
	public void pewPew(ActionEvent e){
		effectSound = 18;
		soundBoardPlayer();
	}
	public void punch(ActionEvent e){
		effectSound = 19;
		soundBoardPlayer();
	}
	public void scramble(ActionEvent e){
		effectSound = 20;
		soundBoardPlayer();
	}
	public void scream(ActionEvent e){
		effectSound = 21;
		soundBoardPlayer();
	}
	public void suspense(ActionEvent e){
		effectSound = 22;
		soundBoardPlayer();
		
	}
	public void target(ActionEvent e){
		effectSound = 23;
		soundBoardPlayer();
	}
	public void tieFighter(ActionEvent e){
		for(int i = 1; i > 0; i++){
			effectSound = 24;
			soundBoardPlayer();
			
			try{
				Thread.sleep(1000);
			}
			catch(InterruptedException f){
			}

		}
	}
	public void toasty(ActionEvent e){
		effectSound = 25;
		
		soundBoardPlayer();
	}
	public void victory(ActionEvent e){
		effectSound = 26;
		soundBoardPlayer();
	}
//+------------------------------------+
	
	//public void showText(ActionEvent e);
		//setText();
	
	//}
	
//	These are all the effect options
//+-------------------------------------------+
	public void cycleUp(ActionEvent e){
		if(cycleCount < 50){
			cycleCount = settings[2];
			cycleCount = cycleCount + 1;
			settings[2] = cycleCount;
			cycleCountLabel.setText(Integer.toString(cycleCount));
		}
	}
		
	public void cycleDown(ActionEvent e){
		if(cycleCount > 1){
			cycleCount = settings[2];
			cycleCount = cycleCount - 1;
			settings[2] = cycleCount;
			cycleCountLabel.setText(Integer.toString(cycleCount));
		}
	}
	
	public void balenceLeft2(ActionEvent e){
		if(balance2 > -1.0){
			balance2 = balance2 - .05;
			balanceSetter2();
			effectBalanceLabel.setText(String.valueOf(balance2));
		}
	}
	
	public void balenceRight2(ActionEvent e){
		if(balance2 < 1.0){
			balance2 = balance2 + .05;
			balanceSetter2();
			effectBalanceLabel.setText(String.valueOf(balance2));
		}
	}
	
	public void increaseVolume2(ActionEvent e){
		if(volume2 < 100){
			volume2  = effectSoundVolume[effectSound];
			volume2 = volume2 + 5;
			effectSoundVolume[effectSound] = volume2;
			changeVolume2();
			soundVolume.setText(Integer.toString(effectSoundVolume[effectSound]) + "%");
		}
	}
	
	public void decreaseVolume2(ActionEvent e){
		if(volume2 > 0){
			volume2  = effectSoundVolume[effectSound];
			volume2 = volume2 - 5;
			effectSoundVolume[effectSound] = volume2;
			changeVolume2();
			soundVolume.setText(Integer.toString(effectSoundVolume[effectSound]) + "%");
		}
	}
	
	public void increaseSpeed2(ActionEvent e){
		if(speed2 < 200){
			speed2 = effectSpeeds[effectSound];
			speed2 = speed2 + 5;
			effectSpeeds[effectSound] = speed2;
			changeSpeed2();
			speedLabel2.setText(Integer.toString(effectSpeeds[effectSound]) + "%");
		}
	
	}
	
	public void decreaseSpeed2(ActionEvent e){
		if(speed2 > 5){
			speed2 = effectSpeeds[effectSound];
			speed2 = speed2 - 5;
			effectSpeeds[effectSound] = speed2;
			changeSpeed2();
			speedLabel2.setText(Integer.toString(effectSpeeds[effectSound]) + "%");
		}
	}
//+--------------------------------------------+
	
	
	
	
	
	
//	The are all the methods tht control the effects
//+--------------------------------------------------+
	public void soundBoardPlayer(){
		media_2 = new Media(sounds.get(effectSound).toURI().toString());
		
		mediaPlayer_2 = new MediaPlayer(media_2);
		setCycle();
		setText();
		balanceSetter2();
		changeSpeed2();
		changeVolume2();
		
		mediaPlayer_2.play();
	
	}
	
	public void balanceSetter2(){
		mediaPlayer_2.setBalance(balance2);
	}
	
	public void setText(){
		speedLabel2.setText(Integer.toString(effectSpeeds[effectSound]) + "%");
		soundVolume.setText(Integer.toString(effectSoundVolume[effectSound]) + "%");
	}
	
	public void changeVolume2(){
		mediaPlayer_2.setVolume(effectSoundVolume[effectSound] * 0.01);
	}
	
	public void changeSpeed2(){
		mediaPlayer_2.setRate(effectSpeeds[effectSound] * 0.01);
	}
	
	public void setCycle(){
		mediaPlayer_2.setCycleCount(cycleCount);
	}
	
	public void beginLoop(){//use to call next song
		loopCycle = loop;
		if(runningLoop == false){
			loopExist = true;
			Echo = new Timer();
			//System.out.println("billy");
			EchoTask = new TimerTask(){
			
			
			public void run(){
				
				runningLoop = true;
				double current = mediaPlayer.getCurrentTime().toSeconds();
				double end = media.getDuration().toSeconds();
				
				System.out.println(current);
				
				
				
				
				if(current/end == 1){
					
					
					
					
					
				}
				else if(loopCycle == loop){
					cancelTimer2();
				}
			}
				
			
			};
		Echo.scheduleAtFixedRate(task, 500, 500);
		
		}
		}
	
	public void cancelTimer2(){
		runningLoop = false;
		Echo.cancel();
	}
//+--------------------------------------------------+
	
	
	public static void clearScreen() { // credit goes to adrian veliz for this line
		try{//windows
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch(Exception e){//mac and linux
			try{
				String term = System.getenv("TERM"); // https://docs.oracle.com/javase/8/docs/api/java/lang/System.html#getenv-java.lang.String-
				if(term != null && !term.equals("dumb")){
					new ProcessBuilder("clear").inheritIO().start().waitFor();
				}
			}catch(Exception e2){}
		}
	}
}


	
	
