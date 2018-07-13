package com.spring.dto;

import javax.persistence.*;

@Entity
@Table(name = "stream_group")
public class StreamGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "stream_id")
    private Stream streamId;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group groupId;

    public StreamGroup() {
    }

    public StreamGroup(Stream streamId, Group groupId) {
        this.streamId = streamId;
        this.groupId = groupId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Stream getStreamId() {
        return streamId;
    }

    public void setStreamId(Stream streamId) {
        this.streamId = streamId;
    }

    public Group getGroupId() {
        return groupId;
    }

    public void setGroupId(Group groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "StreamGroup{" +
                "id=" + id +
                ", streamId=" + streamId +
                ", groupId=" + groupId +
                '}';
    }
}
