public class Player{
    private String name;
    private int element;
    
    public Player(String name, int element){
        this.name = name;
        
        if(element != Board.ELEMENT_X && element != Board.ELEMENT_O){
            this.element = -1;
            return;
        }

        this.element = element;
    }

    public String getName(){
        return name;
    }

    public int getElement(){
        return element;
    }

    public int[] move(){
        return new int[]{0, 0};
    }
}
