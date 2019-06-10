package com.example.harpal.quiz;

/**
 * Created by Harpal on 25-Aug-18.
 */

public class QuestionLibrary {
    private String mQuestions[]={
            "1) 'OS' computer abbreviation usually means ?",
            "2) '.MOV' extension refers usually to what kind of file?",
            "3) Who developed Yahoo?",
            "4) '.INI' extension refers usually to what kind of file?",
            "5) Java was originally invented by",
            "6) The unit of speed used for super computer is",
            "7) India’s first super computer is",
            "8) ROM is composed of",
            "9) ISDN stands for",
            "10) FPI stands for"
    };

    private String mChoice[][]={
            {"Order of Significance","Open Software","Operating System"},
            {"Image file","Animation/movie file","MS Office document"},
            {"Dennis Ritchie & Ken Thompson","David Filo & Jerry Yang","Vint Cerf & Robert Kahn"},
            {"Image file","System file","Hypertext related file"},
            {"Oracle","Microsoft","Sun"},
            {"KELOPS","GELOPS","MELOPS"},
            {"Param","Flow solver","Agni"},
            {"Magnetic cores","Microprocessors","Photoelectric cells"},
            {"International Standard Digital Network","Integrated Service Digital Network","Integrated System Digital Network"},
            {"Faults per inch","Frames per inch","Film per inch"}
    };
    private  String mCorrectAnswer[]={"Operating System","Animation/movie file","David Filo & Jerry Yang","System file",
            "Sun","GELOPS","Param","Photoelectric cells",
            "Integrated Service Digital Network","Frames per inch"};


    public String getQuestion(int a){
        String question =mQuestions[a];
                return question;
    }

    public String choice1(int a){
        String choice0=mChoice[a][0];
        return choice0;
    }

    public String choice2(int a){
        String choice1=mChoice[a][1];
        return choice1;
    }

    public String choice3(int a){
        String choice2=mChoice[a][2];
        return choice2;
    }

    public String getCorrectAnswer(int a){
        String answer=mCorrectAnswer[a];
        return answer;
    }
}
