package org.example.repository;

import org.example.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MessageRepository extends JpaRepository<Message, UUID> {

    @Query(value = """
            SELECT COUNT(m)
            from Message m
            where m.status = 'PROCESSED'
            """)
    Integer getStatisticProcessedMessage();
}
