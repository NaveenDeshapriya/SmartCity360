package urbantechsolution.com.model.decorator;

import urbantechsolution.com.service.Security;

public abstract class SecurityDecorator implements Security {

    protected Security security;
    public SecurityDecorator(Security security) {
        this.security = security;
    }
}
