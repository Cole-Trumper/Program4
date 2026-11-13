/**
 * Generates and prints a complete menu of all the possible hot dog topping combinations
 *
 * @author Cole Trumper
 * Class CS1121
 */

public class HotDog {

    // Base price of a plain dog in a bun in cents

    private static final int BASE_PRICE = 99;

    // Array of avaliable toppings names.

    private static final String[] TOPPINGS = {
	"Ketchup",
	"Mustard",
	"Chopped Onions",
	"Tomato Wedge",
	"Sweet Relish",
	"Sport Peppers",
	"Sauerkraut"
    };

    // Array of topping prices in cents corresponding to toppings in order.
    private static final int[] PRICES = {
	15, 17, 20, 25, 30, 35, 45
    };

    /**
     * Entry point that tests the printMenu method and verifies the count.
     *Initiates HotDog as an object and genertes the menu
     *verifies that all 128 topping combinations are created
     */

    public static void main(String[] args) {
	HotDog obj = new HotDog();
	long count = obj.printMenu();
	assert count == 128;
    }

    /**
     *Prints all possible combinations and the prices in a loop
     *@return the total number of combinations printed (128)
     */
    public long printMenu() {
	long[] count = {0};
	for (int targetSize = 0; targetSize <= TOPPINGS.length; targetSize++) {
	    printCombinations(0,targetSize,"", BASE_PRICE, count);
	}
	//returns the total number of menu items generated
	return count[0];
    }
	/**
	 *Makes and prints teh combinations of a specific topping count.
	 *@param startIndex the starting index in TOPPINGS to consider
	 *@param remaining the number of toppings still needed
	 *@param currentText the accumulated topping string so far
	 *@param currentCents the accumulated price in cents so far
	 *@param count Single element array tracking the menu item number
	 */
	private void printCombinations(int startIndex, int remaining, String currentText, int currentCents, long[] count) {
	    if (remaining == 0) {
		String item = "Dog in Bun ";
		if (!currentText.isEmpty()) {
		    item += "with " + currentText;
		}
		//converts cents to dollars
		double priceInDollars = currentCents / 100.0;
		    System.out.printf("%3d %-60s $%4.2f%n", count[0], item, priceInDollars);
		//Total combination counter
		    count[0]++;
		    return;
	    }

	    // check through the remaining toppings avaliable
	    for (int i = startIndex; i <= TOPPINGS.length - remaining; i++) {
		String nextText = currentText.isEmpty()
		    ? TOPPINGS[i]
		    : currentText +", " + TOPPINGS[i];
		printCombinations(i + 1, remaining -1, nextText, currentCents + PRICES[i], count);
	    }
	}
    }
