package com.georgehigbie;

/**
 * Created by georgehigbie on 11/29/16.
 */
public class PasswordEntry {

    String password;
    char[] special = {'#','@','$','%','&','!'};
    String[] blackList = {"A123456a#", "X123456a@", "a1234&@56a#", "aaaaX1#", "bill", "bob", "cat111111"};



    public String getPassword() {
        return password;
    }



    public void setPassword(String password) {
        char [] charPassword = password.toCharArray();
        int passwordLength = password.length();
        int arrayLength = charPassword.length;
        int [] ASCIIPassword = new int[arrayLength];
        boolean isValidPassword = true;
        String notValid = "This is not a valid password! ";


        //length validation
        if(passwordLength < 8 || passwordLength >16){
            isValidPassword = false;
            System.out.println(notValid + "Your password must be between 8 and 16 characters long.");
        }

        //converts char Array to ASCII numbers to validate characters
        for(int a = 0; a < arrayLength; a++){
            ASCIIPassword[a] = (int) charPassword[a]; //convert char array to ASCII numbers
        }
        //general validation of all Characters -- makes sure we are using valid charcater set before testing for specifics
        for(int b = 0; b < arrayLength; b++){
            if(ASCIIPassword[b] < 33 || ASCIIPassword[b] == 34 ||
                    (ASCIIPassword[b] < 48 && ASCIIPassword[b] > 38) ||
                    (ASCIIPassword[b] < 65 && ASCIIPassword[b] > 57) ||
                    (ASCIIPassword[b] < 97 && ASCIIPassword[b] > 90) ||
                    (ASCIIPassword[b] > 122)){
                isValidPassword = false;
                System.out.println(notValid + "Please use valid characters.");
                break;
            }

        }
        //validates first character as letter -- two if statements used
        if(ASCIIPassword[0] < 65 || ASCIIPassword[0] > 122){//checks to see if first character is in general range of ASCII chars
            isValidPassword = false;
            System.out.println(notValid + "The first letter of your password must be an letter.");
        }

        //excludes symbols in ASCII chart
        if(ASCIIPassword[0] < 97 && ASCIIPassword[0] > 90){//checks to see if first character is a letter in symbol range of ASCII chart
            isValidPassword = false;
            System.out.println(notValid + "The first letter of your password must be an letter.");
        }


        //checks shortlist of banned words -- this is also a very short for loop
        for(String c : blackList){
            if(c.equals(password)){
                isValidPassword = false;
                System.out.println(notValid + "Your password cannot be " + c);
                break;
            }
        }

        //checks of one number, one lowercase letter and one capital letter
        int numberChecker = 0;
        int lowercaseChecker = 0;
        int uppercaseChecker = 0;

        for(int d = 0; d < arrayLength; d++){
            if(ASCIIPassword[d] > 47 && ASCIIPassword[d] < 58){
                numberChecker = 1;
            }

            if(ASCIIPassword[d] > 96 && ASCIIPassword[d] < 123){
                lowercaseChecker = 1;
            }

            if(ASCIIPassword[d] > 64 && ASCIIPassword[d] < 91){
                uppercaseChecker = 1;
            }
        }

        if(numberChecker < 1 || lowercaseChecker < 1 || uppercaseChecker < 1){
            isValidPassword = false;
            System.out.println(notValid + "Your password must include one number, one lowercase letter, and one uppercase letter");
        }


        //special character validation
        int specialChar = 0;
        for(int e = 0; e < special.length; e++){
            for(int f = 0; f < arrayLength; f++){
                if(special[e] == charPassword[f]){
                    specialChar = 1;
                    break;
                }

            }

        }


        if(specialChar == 0){
            System.out.println(notValid + "You must include a special character: #, @, $, %, & or !" );
            isValidPassword = false;
        }

        for(int g = 1; g < arrayLength; g++){
            if(charPassword[g-1] == charPassword[g]){
                isValidPassword = false;
                System.out.println(notValid + "You must not repeat characters" );
                break;
            }
        }


        if(isValidPassword == true){
            System.out.println("Thank you for providing a valid password : )");
            this.password = password;
        }


    }
    //this should be a method that uses built in methods
    public void setPassword2(String password){
        char [] charPassword = password.toCharArray();
        int passwordLength = password.length();
        int arrayLength = charPassword.length;
        int [] ASCIIPassword = new int[arrayLength];
        boolean isValidPassword = true;
        String notValid = "This is not a valid password! ";

        //length validation
        if(passwordLength < 8 || passwordLength >16){
            isValidPassword = false;
            System.out.println(notValid + "Your password must be between 8 and 16 characters long.");
        }


        //special character validation
        int specialChar = 0;
        for(int e = 0; e < special.length; e++){
            for(int f = 0; f < arrayLength; f++){
                if(special[e] == charPassword[f]){
                    specialChar = 1;
                    break;
                }

            }

        }

        if(specialChar == 0){
            System.out.println(notValid + "You must include a special character: #, @, $, %, & or !" );
            isValidPassword = false;
        }

        //validates first character as letter is uppercase or lowercase letter
        if(Character.isLowerCase(password.charAt(0)) == false && Character.isUpperCase(password.charAt(0)) == false){
            System.out.println(notValid + "The first letter of your password must be an letter.");
        }

        //tests to see if char is letter or number ---needs to have special character
        for(int a = 0; a < arrayLength; a++){
            if((Character.isUpperCase(password.charAt(a)) == false || Character.isLowerCase(password.charAt(a)) == false
                    || Character.isDigit(password.charAt(a)) == false) && specialChar == 0){
                isValidPassword = false;
                System.out.println(notValid + "Please use valid characters." );
                break;
            }
        }
        //checks of one number, one lowercase letter and one capital letter
        int numberChecker = 0;
        int lowercaseChecker = 0;
        int uppercaseChecker = 0;

        for(int d = 0; d < arrayLength; d++){
            if(Character.isDigit(password.charAt(d)) == true){
                numberChecker = 1;
            }

            if(Character.isLowerCase(password.charAt(d)) == true) {
                lowercaseChecker = 1;
            }

            if(Character.isUpperCase(password.charAt(d)) == true){
                uppercaseChecker = 1;
            }
        }

        if(numberChecker < 1 || lowercaseChecker < 1 || uppercaseChecker < 1){
            isValidPassword = false;
            System.out.println(notValid + "Your password must include one number, one lowercase letter, and one uppercase letter");
        }

        //checks shortlist of banned words -- this is also a very short for loop
        for(String c : blackList){
            if(c.equals(password)){
                isValidPassword = false;
                System.out.println(notValid + "Your password cannot be " + c);
                break;
            }
        }

        for(int g = 1; g < arrayLength; g++){
            if(charPassword[g-1] == charPassword[g]){
                isValidPassword = false;
                System.out.println(notValid + "You must not repeat characters" );
                break;
            }
        }


        if(isValidPassword == true){
            System.out.println("Thank you for providing a valid password : )");
            this.password = password;
        }




    }
}

