package use_cases.rate;

import model.command.CommandRepository;

public class RateDeliverer {
    CommandRepository commandRepository;

    void rateDeliverer(Long delivererId, int rate){
        try{
            commandRepository.rateDeliverer(delivererId, rate);
        }catch (Error error) {
            System.err.println(error.getMessage());
        }
    }
}
