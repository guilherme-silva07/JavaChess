package pieces;

public class Queen extends Piece {
    public Queen(boolean active, PieceType.Color color, String figure,int posX,int posY) {
        super(active, color, figure,posX,posY);
    }

    @Override
    public boolean validMov(int x, int y) {
        return true;
    }

    @Override
    public void move(int x, int y) {

    }
}
