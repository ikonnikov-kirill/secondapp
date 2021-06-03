package shell;

import lombok.Getter;

@Getter
public enum Command {

    HELP("-help", "-help", "Print help"),
    GET_CATALOG("-cat", "-cat", "Get product catalog"),
    GET_CART("-cart", "-cart", "Get customers cart"),
    NEW_CART("-newcart", "-newcart", "Get new Cart"),
    ADD("-add", "-add [id]", "Add product by id"),
    REMOVE("-remove", "-remove [id]", "Remove product by number in cart"),
    REMOVE_ALL("-remove -all", "-remove -all [id]", "Remove all products by number in cart"),
    CLEAR("-clear", "-clear" , "Clear cart"),
    EXIT("-q", "-q", "Exit");

    private final String cmd;

    private final String cmdSyntax;

    private final String cmdDescription;

    Command(String cmd, String cmdSyntax, String cmdDescription) {
        this.cmd = cmd;
        this.cmdSyntax = cmdSyntax;
        this.cmdDescription = cmdDescription;
    }
}
