package DesignPatterns.BuilderPattern;

public class UrlBuilder {
    private final String protocol;
    private final String hostname;
    private final String port;
    private final String pathParam;
    private final String queryParam;

    private UrlBuilder(Builder builder)
    {
        this.protocol = builder.protocol;
        this.hostname = builder.hostname;
        this.port = builder.port;
        this.pathParam = builder.pathParam;
        this.queryParam = builder.queryParam;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getHostname() {
        return hostname;
    }

    public String getPort() {
        return port;
    }

    public String getPathParam() {
        return pathParam;
    }

    public String getQueryParam() {
        return queryParam;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(protocol).append(hostname);
        //sb.append(hostname);
        return sb.toString();
    }

    static class Builder {
        private String protocol;
        private String hostname;
        private String port;
        private String pathParam;
        private String queryParam;

        public Builder setProtocol(String protocol) {
            this.protocol = protocol;
            return this;
        }

        public Builder setHostname(String hostname) {
            this.hostname = hostname;
            return this;
        }

        public Builder setPort(String port) {
            this.port = port;
            return this;
        }

        public Builder setPathParam(String pathParam) {
            this.pathParam = pathParam;
            return this;
        }

        public Builder setQueryParam(String queryParam) {
            this.queryParam = queryParam;
            return this;
        }

        public UrlBuilder build()
        {
            UrlBuilder urlBuilder = new UrlBuilder(this);
            return urlBuilder;
        }
    }
}
