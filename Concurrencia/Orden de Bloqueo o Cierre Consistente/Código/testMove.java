public class testMove {
    public static void main(String[] args) {

        Directory objDir_1 = new Directory("Directory 1");
        Directory objDir_2 = new Directory("Directory 2");

        FileSysUtil_Rev fileSysUtil = new FileSysUtil_Rev();

        moveContents Thread_A = new moveContents(objDir_1, objDir_2, fileSysUtil);
        moveContents Thread_B = new moveContents(objDir_2, objDir_1, fileSysUtil);
    }
}

class moveContents extends Thread {
    private Directory source, destination;
    private FileSysUtil_Rev fileSysUtil;

    public moveContents(Directory source, Directory destination, FileSysUtil_Rev fileSysUtil) {
        this.source = source;
        this.destination = destination;
        this.fileSysUtil = fileSysUtil;

        start();
    }

    public void run() {
        fileSysUtil.moveContents(source, destination);
    }
}