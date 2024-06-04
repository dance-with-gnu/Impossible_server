package dance.withgnu.demo.dto;

public class PoseRequest {
    private String poseName;
    private int poseNumber;

    // Getters and Setters
    public String getPoseName() {
        return poseName;
    }

    public void setPoseName(String poseName) {
        this.poseName = poseName;
    }

    public int getPoseNumber() {
        return poseNumber;
    }

    public void setPoseNumber(int poseNumber) {
        this.poseNumber = poseNumber;
    }
}
