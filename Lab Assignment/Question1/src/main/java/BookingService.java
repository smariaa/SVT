public class BookingService {
    private final PaymentService paymentService;

    public BookingService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void book() {
        paymentService.processPayment();
    }
}

interface PaymentService {
    void processPayment();
}
