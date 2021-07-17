package com.mantiapp.springboot.backend.apirest.auth;

public class JwtConfig {
    public static final String LLAVE_SECRETA = "8MxOG2Cf5!!10z2Mqo1HS7LKeR1^8v";

    public static final String RSA_PRIVATE = "-----BEGIN RSA PRIVATE KEY-----\n" +
            "MIIEpAIBAAKCAQEAqQWM10hZqvjY3qJoSHDQZVH95tuTm03zr2YPAiAjf2sT6rPo\n" +
            "bpI50592VQxmPRuPR3vMeYWZ+kRIhrYzwWXps+UdVRcYzAg3dbAZa+geXrYWQPh/\n" +
            "Xys4Bmcn+lNvXbeTb/WcWV643jT3BNGcFmWGJchn0Ln0Jw6E6ceCvFzHc8FFmrPO\n" +
            "2uQJhD8MtDQm7o/Nv5o1f2Co8akU0GaKAhEjxO1Y7k4RSNVcS1K/I2nc8SNP1hnP\n" +
            "6USPSlhrDl6vu+Aa6RZ81ldQUSOBZwJezjLlRwluLlddj/GLnkYblPX4jWy+XuYU\n" +
            "OUzR875+1RCr4jwlt05OwPuqPOuqvKRXFtrOJwIDAQABAoIBAHKxIHQJVUdOGyNf\n" +
            "wzG807ydGZRo1U2iZMRVlcOUeWICD/7IW+WD9hdi8pIdmtbGd8BDAmpHvUd0xF4d\n" +
            "DxuiAyaeRvwxcxMoVDHY8DcnyEvudUVbGltC4X5+y0LzEPPgGPz1BkYin4GxIRm0\n" +
            "/py4AYJr7f5V4JYMJSbZyh31OyaRGiEHyvfW8BX4g3X2whDzg7XLK3oMK4Ye1pTO\n" +
            "0NxaaRKh0XyWWbWNZQeTm/9p7wRLX1GtVLl/RJVx//+aElScHfApsrx6BK4KIYxY\n" +
            "dFWIM9vvwzPJFX33B5/wsAPcNCXcEJaccHNl+QmI1ncqDEsUx8Br9AEYCBQXIvkL\n" +
            "IHkL8QkCgYEA1+i1L5K6tvSjNwVDK3COhvmg2TRPVpAg3ftIFnAn+RAuC0UpOFDz\n" +
            "nuMobuatua1iAWD8UZNoVdXyMP/evWoF50gXmiBp67zkbn3+Wn5zpxkC29Ildyfk\n" +
            "0kBKRnRC98DEP0rUUF2MEhrnUUgrWmtFjZxl5olkiBp6b422QWeelH0CgYEAyGgK\n" +
            "YImYxpRHlEZKpAFz5DsTIBWIn4vHA6Q1fD/4adryzQW0YUFjAAWgZnOhPxLDuH+x\n" +
            "KJHDWBe+fs3EUU+BwTW64M9a/zSqYOcyVIj203PNmSZUQmPm5+XHeJrqXqMDlewb\n" +
            "cQW+nfGYLxNq+id562bAkbo5SfUtX1tEN5bzonMCgYAJ6bxP59u8xLSttQclenCA\n" +
            "z/tLnbQ61Dk+F+hyZ0nejJigmddPp5/X3rQfi2XUjZpfV9Wd5Te4IS+Sglz2s2R7\n" +
            "/vpecDiMw0p1rEE+ZGno9SQFdbuUofdGk/8VBweAGpCoG0ZuPi1NM4EFYVvkNeKm\n" +
            "otSm5g4Alb6jWo1QqXJFfQKBgQCCsfcyhgmwV7tmo4DB/ICL80rBvclf41Rit5B5\n" +
            "+24R+swlkPbWBkJ+HS1CI16hN6eUhxIOFyGCLdn58E97h5JjYpsBSblafgovMBfO\n" +
            "sZPmyrrmieyhb22DBoNT0BPQrBcGivhKeSia8JgC+3LkuSH1twkXAI+j/9UbPvX6\n" +
            "GuPAqQKBgQChKkrPaLp6lp9xLb2GF9QUeQaWr5HsSU9VkYVKSTWWyAyZBe1Kzv+4\n" +
            "oeB5dqF8Y/yN8foq+36PeAlAlp/Tm6j/nJlrbRxzx7Oc14/Cu7xWchjAa/K/0o60\n" +
            "TAFc8s12gQBGdPQZdAA8TLzFSP74Gt0l8603KvUpq5NiH4dcxJsi/Q==\n" +
            "-----END RSA PRIVATE KEY-----";
    public static final String RSA_PUBLIC = "-----BEGIN PUBLIC KEY-----\n" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqQWM10hZqvjY3qJoSHDQ\n" +
            "ZVH95tuTm03zr2YPAiAjf2sT6rPobpI50592VQxmPRuPR3vMeYWZ+kRIhrYzwWXp\n" +
            "s+UdVRcYzAg3dbAZa+geXrYWQPh/Xys4Bmcn+lNvXbeTb/WcWV643jT3BNGcFmWG\n" +
            "Jchn0Ln0Jw6E6ceCvFzHc8FFmrPO2uQJhD8MtDQm7o/Nv5o1f2Co8akU0GaKAhEj\n" +
            "xO1Y7k4RSNVcS1K/I2nc8SNP1hnP6USPSlhrDl6vu+Aa6RZ81ldQUSOBZwJezjLl\n" +
            "RwluLlddj/GLnkYblPX4jWy+XuYUOUzR875+1RCr4jwlt05OwPuqPOuqvKRXFtrO\n" +
            "JwIDAQAB\n" +
            "-----END PUBLIC KEY-----";

}
