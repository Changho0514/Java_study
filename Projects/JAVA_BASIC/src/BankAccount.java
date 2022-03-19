// BankAccount.java
public class BankAccount {
    private int balance;
    private Person owner;

    public BankAccount(int balance) {
        if (balance < 0) {
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    public BankAccount(Person owner) {
        this.owner = owner;
        this.balance = 0;
    }

    public BankAccount(int balance, Person owner) {
        if (balance < 0) {
            this.balance = 0;
        } else {
            this.balance = balance;
        }
        this.owner = owner;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    boolean deposit(int amount) {
        if (amount < 0 || owner.getCashAmount() < amount) {
            System.out.println("입금 실패입니다. 잔고: " + balance + "원, 현금: " + owner.getCashAmount() + "원");
            return false;
        }

        balance += amount;
        this.owner.setCashAmount(this.owner.getCashAmount() - amount);

        System.out.println(amount + "원 입금하였습니다 잔고: " + balance + "원, 현금: " + owner.getCashAmount() + "원");

        return true;
    }

    boolean withdraw(int amount) {
        if (amount < 0 || amount > balance) {
            System.out.println("출금 실패입니다 잔고: " + balance + "원, 현금: " + owner.getCashAmount() + "원");
            return false;
        }

        balance -= amount;
        this.owner.setCashAmount(this.owner.getCashAmount() + amount);

        System.out.println(amount + "원 출금하였습니다 잔고: " + balance + "원, 현금: " + owner.getCashAmount() + "원");

        return true;
    }

    public boolean transfer(Person to, int amount) {
        return transfer(to.getAccount(), amount);
    }

    public boolean transfer(BankAccount to, int amount) {
        if (amount < 0 || amount > balance) {
            System.out.println("false - from: " + owner.getName() + ", to: " + to.owner.getName() + ", amount: " + amount + ", balance: " + balance);
            return false;
        } else {
            balance -= amount;
            to.balance += amount;
            System.out.println("true - from: " + owner.getName() + ", to: " + to.owner.getName() + ", amount: " + amount + ", balance: " + balance);
            return true;
        }
    }
}



    public Person(String name) {
        this(name, 12, 0); // 12살을 기본 나이로 설정, 초기 현금 보유액은 0원.
    }

    public Person(String name, int age) {
        this(name, age, 0); // 초기 현금 보유액은 0원.
    }

    public Person(String name, int age, int cashAmount) {
        if (age < 0) {
            this.age = 12;
        } else {
            this.age = age;
        }

        if (cashAmount < 0) {
            this.cashAmount = 0;
        } else {
            this.cashAmount = cashAmount;
        }
        this.name = name;
    }