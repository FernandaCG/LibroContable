package com.nearsoft.academy.ledger.util;

public class RegularExpression{

    private RegularExpression() {
    }

    public static final String DATE = "[0-9]{4}/[0-9]+/[0-9]+";
    public static final String ACCOUNT = "[a-zA-Z]+";
    public static final String SUBACCOUNT = ":[a-zA-Z]+[\\s]?[a-zA-Z]*:?[a-zA-Z]*[\\s]?";
    public static final String ACC2 = "[a-zA-Z]+:[a-zA-Z]+[\\s]?[a-zA-Z]*:?[a-zA-Z]*[\\s]?";
    public static final String AMMOUNT = "[\\s][-]?[$]?[\\d]+";


}