package Services;

import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.List;

public class API {
    // List of male names
    ArrayList<String> maleNames = new ArrayList<>(
            List.of(
                    "Mohamed" ,
                            "Ahmed" ,
                            "Mahmoud" ,
                            "Mostafa" ,
                            "Amr" ,
                            "Ali" ,
                            "Ibrahim" ,
                            "Khaled" ,
                            "Omar" ,
                            "Ayman" ,
                            "Ashraf" ,
                            "Hassan" ,
                            "Hossam" ,
                            "Adel" ,
                            "Sherif" ,
                            "Osama" ,
                            "Hany" ,
                            "Eslam" ,
                            "Yasser" ,
                            "Tarek" ,
                            "Sayed" ,
                            "Karim" ,
                            "Emad" ,
                            "Hesham" ,
                            "Wael" ,
                            "Tamer" ,
                            "Islam" ,
                            "Sameh" ,
                            "Hamza" ,
                            "Walid" ,
                            "Ehab" ,
                            "Youssef" ,
                            "Essam" ,
                            "Salah" ,
                            "Magdy" ,
                            "Abdul" ,
                            "Abdullah" ,
                            "Hussein" ,
                            "Samir" ,
                            "Mido" ,
                            "Hazem" ,
                            "Waleed"
            )
    );
    // List of female names
    ArrayList<String> femaleNames = new ArrayList<>(
            List.of(
                    "Eman" ,
                            "Mona" ,
                            "Ghada" ,
                            "Heba" ,
                            "Sara" ,
                            "Aya" ,
                            "Marwa" ,
                            "Asmaa" ,
                            "Amira" ,
                            "Dina" ,
                            "Nada" ,
                            "Fatma" ,
                            "Amal" ,
                            "Mai" ,
                            "Doaa" ,
                            "Mariam" ,
                            "Noha" ,
                            "Maha" ,
                            "Esraa" ,
                            "Rania" ,
                            "Salma" ,
                            "Nour" ,
                            "Hanan" ,
                            "Dalia" ,
                            "Rasha" ,
                            "Hala" ,
                            "Sarah" ,
                            "Samar" ,
                            "Shimaa" ,
                            "Amany" ,
                            "Reham" ,
                            "Hoda" ,
                            "Basma" ,
                            "Menna" ,
                            "Abeer" ,
                            "Manal" ,
                            "Sahar" ,
                            "Hend" ,
                            "Rehab" ,
                            "Walaa" ,
                            "Azza" ,
                            "Rana" ,
                            "Reem" ,
                            "Nadia" ,
                            "Shaimaa" ,
                            "Wafaa" ,
                            "Malak" ,
                            "Yasmin" ,
                            "Samah" ,
                            "Habiba"
            )
    );
    // Function to randomly generate a male or female name
    public String generateName(){
        String name;
        int firstName;
        int secondName;
        int gender = ThreadLocalRandom.current().nextInt(0, 1 + 1);
        if(gender == 0){
            firstName = ThreadLocalRandom.current().nextInt(0, maleNames.size());
            secondName = ThreadLocalRandom.current().nextInt(0, maleNames.size());
            name = maleNames.get(firstName) + " " + maleNames.get(secondName);
        }
        else{
            firstName = ThreadLocalRandom.current().nextInt(0, femaleNames.size());
            secondName = ThreadLocalRandom.current().nextInt(0, maleNames.size());
            name = femaleNames.get(firstName) + " " + maleNames.get(secondName);
        }
        return name;
    }
}
