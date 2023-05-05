public class Piece {

    public enum typeOfPiece {
        X,
        O
    }

    typeOfPiece type;

    public Piece(typeOfPiece type){
        this.type = type;
    }
}
