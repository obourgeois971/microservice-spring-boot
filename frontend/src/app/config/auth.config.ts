import { PassedInitialConfig } from 'angular-auth-oidc-client';
// authority: 'http://keycloak.default.svc.cluster.local:8080/realms/spring-microservices-security-realm',
export const authConfig: PassedInitialConfig = {
  config: {
    authority: 'http://192.168.150.4:8181/realms/spring-microservices-security-realm',
    redirectUrl: window.location.origin,
    postLogoutRedirectUri: window.location.origin,
    clientId: 'angular-client',
    scope: 'openid profile offline_access',
    responseType: 'code',
    silentRenew: true,
    useRefreshToken: true,
    renewTimeBeforeTokenExpiresInSeconds: 30,
  }
}
