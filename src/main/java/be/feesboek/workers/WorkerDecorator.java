package be.feesboek.workers;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public abstract class WorkerDecorator implements Worker {

    @Inject
    @Delegate
    @Any
    Worker worker;

    @Override
    public String transform(String text) {
        return "DECORATED TRANSFORMATION: Fa lala la la " + worker.transform(text) + ", falala la la la.";
    }
}
