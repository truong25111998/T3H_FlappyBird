package gameflappybird;

public class DiemSo {

    private static int diem = 0;
    private static int diemmoi;
    private ConChim conChimD = new ConChim();
    private OngNuoc ongNuocD = new OngNuoc();
    private static boolean b = false;
    private SoundManager soundpoint;

    public static int getDiem() {
        return diem;
    }

    public void congDiem() {
        soundpoint = new SoundManager("/Sound/sfx_point.wav");
        {
            if ((conChimD.getX() + 32) > ongNuocD.getX1() && conChimD.getX() < (ongNuocD.getX1() + 55)) {
                b = true;
            }
            if (b == true && conChimD.getX() > ongNuocD.getX1() + 55) {
                soundpoint.play(false);
                diem = diem + 1;
                b = false;

            }
            if ((conChimD.getX() + 32) > ongNuocD.getX2() && conChimD.getX() < (ongNuocD.getX2() + 55)) {
                b = true;
            }
            if (b == true && conChimD.getX() > ongNuocD.getX2() + 55) {
                soundpoint.play(false);
                diem = diem + 1;
                b = false;

            }

            if ((conChimD.getX() + 32) > ongNuocD.getX3() && conChimD.getX() < (ongNuocD.getX3() + 55)) {
                b = true;
            }
            if (b == true && conChimD.getX() > ongNuocD.getX3() + 55) {
                soundpoint.play(false);
                diem = diem + 1;
                b = false;

            }
        }

    }
}
