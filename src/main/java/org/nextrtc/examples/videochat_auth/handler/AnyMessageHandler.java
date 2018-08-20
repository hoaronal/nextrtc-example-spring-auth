package org.nextrtc.examples.videochat_auth.handler;

import lombok.extern.slf4j.Slf4j;
import org.nextrtc.examples.videochat_auth.SessionWrapper;
import org.nextrtc.signalingserver.api.NextRTCEvents;
import org.nextrtc.signalingserver.api.NextRTCHandler;
import org.nextrtc.signalingserver.api.annotation.NextRTCEventListener;
import org.nextrtc.signalingserver.api.dto.NextRTCEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@NextRTCEventListener(NextRTCEvents.MESSAGE)
public class AnyMessageHandler implements NextRTCHandler {
    @Override
    public void handleEvent(NextRTCEvent event) {
        if (event.content().equals("leg")) {
            log.info("Received message with content leg");
            event.conversation()
                    .ifPresent(c -> c.getMembers()
                            .stream()
                            .map(m -> (SessionWrapper) m.getConnection())
                            .forEach(sw -> {
                                log.info("Invalidated session: " + sw.getPrincipal());
                                sw.invalidate();
                            }));

        }
    }
}
