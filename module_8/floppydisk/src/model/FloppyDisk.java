package model;

import exceptions.DiskFullException;
import exceptions.IllegalHeadException;
import exceptions.WriteLockException;

public class FloppyDisk {
    private static final int CAPACITY = 1474560;
    private byte[] data;
    private boolean writeLockEnable;
    private int headPosition;

    public FloppyDisk() {
        data = new byte[CAPACITY];
        writeLockEnable = false;
        headPosition = 0;
    }

    public void placeHead(int k) throws IllegalHeadException {
        if (k < 0 || k >= CAPACITY) {
            throw new IllegalHeadException("Invalid position");
        }

        headPosition = k;
    }

    public byte[] read(int x) {
        byte[] result = new byte[x];

        for (int i = 0; i < x; i++) {
            result[i] = data[headPosition++];
        }

        return result;
    }

    public void write(byte[] data) throws WriteLockException {
        if (!writeLockEnable) {
            for (byte datum : data) {
                try {
                    this.data[headPosition++] = datum;
                } catch (IndexOutOfBoundsException e) {
                    throw new DiskFullException("Disk full");
                }
            }
        } else {
            throw new WriteLockException("Write lock enable");
        }
    }

    public void format() throws WriteLockException {
        byte[] data = new byte[CAPACITY];
        write(data);
    }

    public void activeWriteLock() {
        writeLockEnable = true;
    }

    public void disableWriteLock() {
        writeLockEnable = false;
    }

}
