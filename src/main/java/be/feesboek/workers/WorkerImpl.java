package be.feesboek.workers;

import be.feesboek.interceptor.Logged;

public class WorkerImpl implements Worker {

    @Logged
    @Override
    public String transform(String text) {
        return "the transformation of " + text;
    }
    
}
