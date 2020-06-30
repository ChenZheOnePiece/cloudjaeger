package cn.com.github.provide.bean;

import io.jaegertracing.internal.JaegerSpanContext;
import io.opentracing.Scope;
import io.opentracing.Span;
import io.opentracing.util.ThreadLocalScopeManager;
import org.slf4j.MDC;

public class MDCScopeManager extends ThreadLocalScopeManager {

    @Override
    public Scope activate(Span span) {
        Scope activate = super.activate(span);
        mdc(span);
        return activate;
    }


    public void mdc(Span span){
        JaegerSpanContext ctx = (JaegerSpanContext) span.context();
        String traceId = ctx.getTraceId();

        String spanId = Long.toHexString(ctx.getSpanId());
        String sampled = String.valueOf(ctx.isSampled());
        String parentSpanId = Long.toHexString(ctx.getParentId());

        replace("X-B3-TraceId", traceId);
        replace("X-B3-SpanId", spanId);
        replace("parentSpanId", parentSpanId);
        replace("X-Span-Export", sampled);
    }
 
    private static String lookup(String key) {
        return MDC.get(key);
    }
 
    private static void replace(String key, String value) {
        if (value == null) {
            MDC.remove(key);
        } else {
            MDC.put(key, value);
        }
    }
}
