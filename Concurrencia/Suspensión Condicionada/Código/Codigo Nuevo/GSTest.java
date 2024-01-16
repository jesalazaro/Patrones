public class GSTest {
  public static void main(String[] args) {
    Bank banking = new Bank();
    new Member("Member1", banking);
    new Member("Member2", banking);
    new Member("Member3", banking);
    new Member("Member4", banking);
    new Member("Member5", banking);
    new Member("Member6", banking);
    new Member("Member7", banking);
    new Member("Member8", banking);
  }

} class Bank {

  public static final int MAX_CAPACITY = 5;
  private int totalClientsBank = 0;

  public synchronized void bank(String member) {
    while (totalClientsBank >= MAX_CAPACITY) {
      try {
        System.out.println(" The bank is full " +
                member + " has to wait ");
        wait();
      } catch (InterruptedException e) {
        //
      }
    }
    //precondition is true
    System.out.println(member + " has enter the bank");
    totalClientsBank = totalClientsBank + 1;
  }
  public synchronized void leave(String member) {
    totalClientsBank = totalClientsBank - 1;
    System.out.println(member +
            " has left, notify a waiting member");
    notify();
  }
}

class Member extends Thread {
  private Bank banking;
  private String name;

  Member(String n, Bank p) {
    name = n;
    banking = p;
    start();
  }
  public void run() {
    System.out.println(name + " is ready to enter the bank");
    banking.bank(name);
    try {
      sleep(5000);
    } catch (InterruptedException e) {
      //
    }
    //leave after 5000ms
    banking.leave(name);
  }
}
