package com.example.order;

public class ConcreteCommand implements Command {
    private Receiver receiver;

    ConcreteCommand(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        this.receiver.action();
    }
}
