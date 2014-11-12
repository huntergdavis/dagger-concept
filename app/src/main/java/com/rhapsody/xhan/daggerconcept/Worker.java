package com.rhapsody.xhan.daggerconcept;

/**
 * @todo: add class description
 */
public class Worker {
	public int id;
    public String name;

    public Worker(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Worker{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
