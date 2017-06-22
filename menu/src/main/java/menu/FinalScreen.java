package menu;

public class FinalScreen extends SubMenu {

    private MButton nextButton;

    public FinalScreen(/*String message,*/ IMenuAction menu/*, boolean select*/) {
        super(1, menu);

        boolean select =true;
        String message = "test";

        this.nextButton = new MButton(message);

        this.add(nextButton);

        if (select == false){
            nextButton.addActionListener((e -> this.menu.home()));
        }else if(select == true){
            nextButton.addActionListener((e -> this.menu.enterPlay()));
        }
    }

}