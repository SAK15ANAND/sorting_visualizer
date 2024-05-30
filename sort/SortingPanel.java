import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SortingPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private Random random;
    private int[] array;
    private BubbleSort bubbleSort;
    private InsertionSort insertionSort;
    private SelectionSort selectionSort;
    private QuickSort quickSort;

    private JButton start;
    private JButton bubble;
    private JButton insertion;
    private JButton selection;
    private JButton quick;
    private JButton reset;

    private boolean isBubble = false;
    private boolean isInsertion = false;
    private boolean isSelection = false;
    private boolean isQuick = false;

    private boolean isRunning;

    int i = 0;

    public SortingPanel() {

        random = new Random();
        array = new int[80];
        this.setArray();

        bubbleSort = new BubbleSort(array);
        insertionSort = new InsertionSort(array);
        selectionSort = new SelectionSort(array);
        quickSort = new QuickSort(array);

        start = new JButton("Start");
        bubble = new JButton("BubbleSort");
        insertion = new JButton("InsertionSort");
        selection = new JButton("SelectionSort");
        quick = new JButton("QuickSort");
        reset = new JButton("Reset");

        start.setModel(new ButtonModel());
        start.setBackground(Color.yellow);
        start.setFocusPainted(false);
        start.setBorderPainted(false);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    start.setBackground(Color.peach);
                    if (isRunning == false)
                        isRunning = true;
                    animate();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        bubble.setModel(new ButtonModel());
        bubble.setBackground(Color.yellow);
        bubble.setFocusPainted(false);
        bubble.setBorderPainted(false);
        bubble.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (isRunning == false) {
                        isInsertion = false;
                        isSelection = false;
                        isQuick = false;
                        isBubble = true;
                        setButtonBackground();
                        bubble.setBackground(Color.#EFB495);
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        insertion.setModel(new ButtonModel());
        insertion.setBackground(Color.yellow);
        insertion.setFocusPainted(false);
        insertion.setBorderPainted(false);
        insertion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (isRunning == false) {  
                        isBubble = false;
                        isSelection = false;
                        isQuick = false;
                        isInsertion = true;
                        setButtonBackground();
                        insertion.setBackground(Color.#EFB495);
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        selection.setModel(new ButtonModel());
        selection.setBackground(Color.yellow);
        selection.setFocusPainted(false);
        selection.setBorderPainted(false);
        selection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (isRunning == false) {
                        isBubble = false;
                        isInsertion = false;
                        isQuick = false;
                        isSelection = true;
                        setButtonBackground();
                        selection.setBackground(Color.peach);
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        quick.setModel(new ButtonModel());
        quick.setBackground(Color.yellow);
        quick.setFocusPainted(false);
        quick.setBorderPainted(false);
        quick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (isRunning == false) {
                        isBubble = false;
                        isInsertion = false;
                        isSelection = false;
                        isQuick = true;
                        setButtonBackground();
                        quick.setBackground(Color.peach);
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        reset.setModel(new ButtonModel());
        reset.setBackground(Color.yellow);
        reset.setFocusPainted(false);
        reset.setBorderPainted(false);
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                reset.setBackground(Color.peach);
                start.setBackground(Color.yellow);

                setArray();

                // reset bubbleSort object
                bubbleSort.set_Compare_index(Integer.MAX_VALUE);
                bubbleSort.set_Array_Index(0);
                bubbleSort.set_Array(array);

                // reset insertionSort object
                insertionSort.set_compare_index(Integer.MAX_VALUE);
                insertionSort.set_Array_index(Integer.MAX_VALUE);
                insertionSort.set_Array(array);
                insertionSort.start_of_iteration(false);

                // reset quickSort object
                quickSort.setTop(-1);
                quickSort.push(0);
                quickSort.push(79);
                quickSort.setArrayIndex(Integer.MAX_VALUE);
                quickSort.setCompareIndex(Integer.MAX_VALUE);
                quickSort.setPartition(-1);
                quickSort.setIsPartioning(false);

                isRunning = false;

                Timer timer = new Timer(100, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        reset.setBackground(Color.yellow);
                        ((Timer) e.getSource()).stop();
                    }
                });

                timer.start();
                repaint();
            }
        });

        this.add(start);
        this.add(bubble);
        this.add(insertion);
        this.add(selection);
        this.add(quick);
        this.add(reset);
    }

    public void setButtonBackground() {
        bubble.setBackground(Color.yellow);
        insertion.setBackground(Color.yellow);
        selection.setBackground(Color.yellow);
        quick.setBackground(Color.yellow);
    }

    public int[] getArray() {
        return this.array;
    }

    public void setArray() {
        for (int i = 0; i < this.array.length; i++) {
            this.array[i] = random.nextInt(510) + 40;
        }
    }

    public boolean isSorted() {

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public void animate() throws Exception {

        if (isBubble) {

            bubbleSort.set_Compare_index(0);

            Timer bubbleTimer = new Timer(10, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (isSorted() || isRunning == false) {
                        bubbleSort.set_Compare_index(Integer.MAX_VALUE);
                        isRunning = false;
                        start.setBackground(Color.yellow);
                        ((Timer) e.getSource()).stop();
                    } else {
                        if (isRunning == true)
                            array = bubbleSort.sort();
                    }

                    repaint();
                }
            });

            bubbleTimer.start();
        }

        if (isInsertion) {

            insertionSort.set_Array_index(1);

            Timer insertionTimer = new Timer(10, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (isSorted() || isRunning == false) {
                        insertionSort.set_compare_index(Integer.MAX_VALUE);
                        insertionSort.set_Array_index(Integer.MAX_VALUE);
                        insertionSort.start_of_iteration(false);
                        isRunning = false;
                        start.setBackground(Color.yellow);
                        ((Timer) e.getSource()).stop();
                    } else {
                        if (isRunning == true)
                            array = insertionSort.sort();
                    }

                    repaint();
                }
            });

            insertionTimer.start();
        }

        if (isSelection) {

            selectionSort.set_Array_index(0);
            selectionSort.set_Compare_Index(1);
            selectionSort.set_Min_Idx(0);

            Timer selectionTimer = new Timer(10, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (isSorted() || isRunning == false) {
                        selectionSort.set_Compare_Index(Integer.MAX_VALUE);
                        selectionSort.set_Array_index(Integer.MAX_VALUE);
                        selectionSort.set_Min_Idx(Integer.MAX_VALUE);
                        isRunning = false;
                        start.setBackground(Color.yellow);
                        ((Timer) e.getSource()).stop();
                    } else {
                        if (isRunning == true)
                            array = selectionSort.sort();
                    }

                    repaint();
                }
            });

            selectionTimer.start();
        }

        if (isQuick) {

            Timer quickTimer = new Timer(10, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (isSorted() || isRunning == false) {
                        quickSort.setTop(-1);
                        quickSort.push(0);
                        quickSort.push(79);
                        quickSort.setArrayIndex(Integer.MAX_VALUE);
                        quickSort.setCompareIndex(Integer.MAX_VALUE);
                        quickSort.setPartition(-1);
                        quickSort.setIsPartioning(false);
                        isRunning = false;
                        start.setBackground(Color.yellow);
                        ((Timer) e.getSource()).stop();
                    }

                    else {
                        if (isRunning == true)
                            array = quickSort.sort();
                    }

                    repaint();
                }
            });

            quickTimer.start();
        }
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        this.setBackground(Color.BLACK);

        for (int i = 0; i < array.length; i++) {

            g.setColor(Color.BLACK);
            g.drawRect(i * 15, 600 - array[i], 14, array[i]);

            if (isBubble) {

                if (i == bubbleSort.get_Compare_index() || i == (bubbleSort.get_Compare_index() + 1)) {
                    g.setColor(Color.RED);
                }

            }

            if (isInsertion) {

                if (i == insertionSort.get_compare_index() || i == (insertionSort.get_compare_index() + 1)) {
                    g.setColor(Color.RED);
                }

                if (i == insertionSort.get_Array_Index()) {
                    g.setColor(Color.GREEN);
                }
            }

            if (isSelection) {

                if (i == selectionSort.get_Compare_Index() || i == selectionSort.get_Min_Idx()) {
                    g.setColor(Color.RED);
                }

                if (i == selectionSort.get_Array_Index()) {
                    g.setColor(Color.GREEN);
                }
            }

            if (isQuick) {

                if (i == quickSort.get_Array_Index()) {
                    g.setColor(Color.RED);
                }

                if (i == quickSort.getCompareIndex()) {
                    g.setColor(Color.BLUE);
                }

                if (i == quickSort.getPartition())
                    g.setColor(Color.GREEN);
            }

            if (g.getColor() != Color.RED && g.getColor() != Color.GREEN && g.getColor() != Color.BLUE)
                g.setColor(Color.yellow);

            g.fillRect(i * 15, 600 - array[i], 14, array[i]);
        }
    }
}
