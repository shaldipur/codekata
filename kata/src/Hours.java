import java.time.LocalTime;


public class Hours {

    private LocalTime fivePM;
    private LocalTime sixPM;
    private LocalTime sevenPM;
    private LocalTime eightPM;
    private LocalTime ninePM;
    private LocalTime tenPM;
    private LocalTime elevenPM;
    private LocalTime twelveAM;
    private LocalTime oneAM;
    private LocalTime twoAM;
    private LocalTime threeAM;
    private LocalTime fourAM;


    // Set the variables to their values in the constructor
    Hours(){
        fivePM = LocalTime.of(17,00);
        sixPM = LocalTime.of(18,00);
        sevenPM = LocalTime.of(19,00);
        eightPM = LocalTime.of(20,00);
        ninePM = LocalTime.of(21,00);
        tenPM = LocalTime.of(22,00);
        elevenPM = LocalTime.of(23,00);
        twelveAM = LocalTime.of(0,00);
        oneAM = LocalTime.of(1,00);
        twoAM = LocalTime.of(2,00);
        threeAM = LocalTime.of(3,00);
        fourAM = LocalTime.of(4,00);
    }

    // Use get accessor methods to get the values

    public LocalTime getFivePM() {
        return fivePM;
    }

    public LocalTime getSixPM() {
        return sixPM;
    }

    public LocalTime getSevenPM() {
        return sevenPM;
    }

    public LocalTime getEightPM() {
        return eightPM;
    }

    public LocalTime getNinePM() {
        return ninePM;
    }

    public LocalTime getTenPM() {
        return tenPM;
    }

    public LocalTime getElevenPM() {
        return elevenPM;
    }

    public LocalTime getTwelveAM() {
        return twelveAM;
    }

    public LocalTime getOneAM() {
        return oneAM;
    }

    public LocalTime getTwoAM() {
        return twoAM;
    }

    public LocalTime getThreeAM() {
        return threeAM;
    }

    public LocalTime getFourAM() {
        return fourAM;
    }


}
