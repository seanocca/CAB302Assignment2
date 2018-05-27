package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Delivery.Manifest;
import Delivery.Truck;
import Exceptions.CSVFormationException;
import Exceptions.DeliveryException;
import Exceptions.StockException;
import Stock.Item;
import Stock.Stock;

public class GUIModel extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5268871775670551444L;
	
	public static final int WIDTH = 1000;

   	public static final int HEIGHT = 750;

   	//Create all the Buttons from the application
	private static JButton importItems;	
	private static JButton exportManifestButton;	
	private static JButton importManifest;	
	private static JButton importSalesLogs;
	
	//Create the Store and the Label that the capital will display in
	private static Store store = new Store("SuperMart", 100000);	
	private static JLabel storeCapital = new JLabel();
	
	//Each panel for the Tabbed Panel
	private static JPanel inventory = new JPanel();
	
	//Components for the Item Properties Table
	private static JTable itemTable;	
	private static DefaultTableModel itemTableModel = new DefaultTableModel(0,0);
	private static JScrollPane itemScroll;	
	private static Object itemColNames[] = { "Name", "Cost", "Price", "Re-Order Point", "Re-Order Amount", "Safe Temperature", "Quantity"};
	
	//Create a local Manifest to store the created manifest
	private Manifest manifest;
	
	//Have a local Stock that holds the Stores Items
	private Stock stockItems = new Stock();	

	/**
	 * 
	 * @author Sean O'Connell
	 */
	public GUIModel() {
		super(store.GetStoreName());
		InitComponents();
	}
	
	/**
	 * 
	 * @author Sean O'Connell
	 */
	private class ImportItems implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Component source = (Component) e.getSource();
            if (source == importItems) {
            	final JFileChooser fc = new JFileChooser();
            	fc.setCurrentDirectory(new java.io.File("."));
                fc.setDialogTitle("Get Item Properties");
            	
            	int returnVal = fc.showOpenDialog(source);
            	Stock array = new Stock();

            	if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    //Import the item properties from the file
                    try {
						BufferedReader read = new BufferedReader(new FileReader(file));		
						String line = read.readLine();
						while(line != null) {
							String[] attributes = line.split(",");
							Item item = new Item(attributes);
							array.add(item);
							line = read.readLine();
						}
						stockItems = new Stock();
						stockItems = array;
						PrintItemsToTable(stockItems);
			    		read.close();
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null,
		    				    "Unable to Read the File",
		    				    "CSV Formation Exception",
		    				    JOptionPane.ERROR_MESSAGE);
					} catch (StockException e1) {
						JOptionPane.showMessageDialog(null,
		    				    "Unable to Import Items",
		    				    "Stock Exception",
		    				    JOptionPane.ERROR_MESSAGE);
					}
                } 
            }
        }
    }
	
	/**
	 * 
	 * @author Sean O'Connell
	 */
	private class ExportManifest implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Component source = (Component) e.getSource();
            if (source == exportManifestButton) {            
	        	try {
	        		Stock newStock = new Stock();
	        		for (Item item: stockItems.GetStockArray()) {
	        			if (item.GetQuantity() <= item.GetReorderPoint()) {
	        				newStock.add(item);
	        			}
	        		}
		    		manifest = new Manifest(newStock);
					PrintManifestToTable(manifest); 		
				} catch (DeliveryException e2) {
					JOptionPane.showMessageDialog(null,
	    				    "Unable to Create Manifest",
	    				    "Stock Exception",
	    				    JOptionPane.ERROR_MESSAGE);
				} catch (CSVFormationException e1) {
					JOptionPane.showMessageDialog(null,
	    				    "CSV Formatting Error in the Manifest",
	    				    "CSV Formation Exception",
	    				    JOptionPane.ERROR_MESSAGE);
				}            
            }
        }
    }
	
	/**
	 * 
	 * @author Sean O'Connell
	 */
	private class ImportManifest implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Component source = (Component) e.getSource();
            if (source == importManifest) {
	        	try {	
	        		for (Item item: stockItems.GetStockArray()) {
	        			if (item.GetQuantity() <= item.GetReorderPoint()) {
	        				item.SetQuantity(item.GetReorderAmount());
	        			}
					}
					store.PayWithCapital(manifest.GetManifestCost());
					storeCapital.setText(store.GetCapitalString());
					PrintItemsToTable(stockItems);
				} catch (StockException e2) {
					JOptionPane.showMessageDialog(null,
	    				    "Unable to Import Manifest",
	    				    "Stock Exception",
	    				    JOptionPane.ERROR_MESSAGE);
				} catch (DeliveryException e1) {
					JOptionPane.showMessageDialog(null,
	    				    "Unable to Get Manifest Cost",
	    				    "Delivery Exception",
	    				    JOptionPane.ERROR_MESSAGE);
				}  
            	
            }
        }
    }
	
	/**
	 * 
	 * @param manifest
	 * @throws CSVFormationException
	 * @throws DeliveryException 
	 * @author Sean O'Connell
	 */
	private void PrintManifestToTable(Manifest manifest) throws CSVFormationException, DeliveryException {
		String path = "./src/Files/manifest.csv";
		FileWriter writer;
		try {
			writer = new FileWriter(path);
			for (Truck truck: manifest.GetManifestArray()) {
				for (String value: truck.GetCargoList()) {
					writer.append(value + "\n");
				}
			}
			writer.close();
		} catch (IOException e) {
			throw new CSVFormationException();
		}
	}
	
	/**
	 * 
	 * @param stockArray
	 * @author Sean O'Connell
	 */
	private void PrintItemsToTable(Stock stockArray) throws StockException {
		itemTableModel.setRowCount(0);
		for (Item item: stockArray.GetStockArray()) {
			if (item.GetTemperature() >= 20) {
				itemTableModel.addRow(new Object[] { item.GetName(), item.GetCost(), item.GetPrice(),
						item.GetReorderPoint(), item.GetReorderAmount(), null, item.GetQuantity()});
			} else {
				itemTableModel.addRow(new Object[] { item.GetName(), item.GetCost(), item.GetPrice(),
						item.GetReorderPoint(), item.GetReorderAmount(), item.GetTemperature(), item.GetQuantity()});
			}
						
		}
		//Print to Item Properties Table
		itemTable.setModel(itemTableModel);
		itemScroll.getViewport().setView(itemTable);
		inventory.add(itemScroll);
	}
	
	/**
	 * 
	 * @author Sean O'Connell
	 */
	private class ImportSalesLogs implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Component source = (Component) e.getSource();
            if (source == importSalesLogs) {
            	final JFileChooser fc = new JFileChooser();
            	fc.setCurrentDirectory(new java.io.File("."));
                fc.setDialogTitle("Get Sales Log");
            	
            	int returnVal = fc.showOpenDialog(source);
            	Stock newSalesLog = new Stock();

            	if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    //Import the item properties from the file
                    try {
						BufferedReader read = new BufferedReader(new FileReader(file));		
						String line = read.readLine();
						while(line != null) {				
							String[] buyItem = line.split(",");
							Item item = new Item(buyItem);
							item.SetBuyingQuantity(Double.parseDouble(buyItem[1]));
							newSalesLog.add(item);
							line = read.readLine();						
						}
						CheckSale(newSalesLog);
						PrintItemsToTable(stockItems);
			    		read.close();
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null,
		    				    "Unable to Read the File",
		    				    "CSV Formation Exception",
		    				    JOptionPane.ERROR_MESSAGE);
					} catch (StockException e1) {
						JOptionPane.showMessageDialog(null,
		    				    "Unable to Import Sales Log",
		    				    "Stock Exception",
		    				    JOptionPane.ERROR_MESSAGE);
					}
                } 
            }
        }
    }
	
	/**
	 * 
	 * @param saleItems
	 * @throws StockException
	 * @author Sean O'Connell
	 */
	private void CheckSale(Stock saleItems) throws StockException {
		ArrayList<String> list = new ArrayList<String>();
		double costPrice = 0;
		for (Item item: stockItems.GetStockArray()) {
			list.add(item.GetName());
		}
		for (Item saleItem: saleItems.GetStockArray()) {
			if (list.contains(saleItem.GetName())) {
				for (Item stockItem: stockItems.GetStockArray()) {					
					if (stockItem.GetName().equals(saleItem.GetName())) {
						stockItem.SetQuantity(-saleItem.GetBuyingQuantity()); 
						costPrice += (saleItem.GetBuyingQuantity() * stockItem.GetPrice());
					}
				} 
			}
		}
		store.SellItemsForCapital(costPrice);
		storeCapital.setText(store.GetCapitalString());
	}
	
	/**
	 * @author Sean O'Connell
	 */
	private void InitComponents() {	
		setSize(WIDTH, HEIGHT);
	    setLayout(new BorderLayout());
	    
		//Tabbed Panel
	    JTabbedPane tabbedPane = new JTabbedPane();

	    //Amount of Capital within a new panel witha flow layout
	    JPanel capitalLabel = new JPanel( new FlowLayout(FlowLayout.LEFT));
	    storeCapital = new JLabel(store.GetCapitalString());
	    capitalLabel.add(storeCapital);
	    
	    //Panel to add Buttons to
	    JPanel buttons = new JPanel();
	    
	    //Load in Inventory Column Names
	    for (int i = 0; i < itemColNames.length; i++) {
			itemTableModel.addColumn(itemColNames[i]);
		}
        
        //Load Item Properties
    	importItems = new JButton("Import Item Properties");
    	buttons.add(importItems);
       
    	 //Load Manifest Button
        exportManifestButton = new JButton("Generate and Export Manifest");
        buttons.add(exportManifestButton);
        
        //Import Sales Log
    	importManifest = new JButton("Import Manifest");
    	buttons.add(importManifest);
        
    	//Import Sales Log
    	importSalesLogs = new JButton("Import Sales Logs");
    	buttons.add(importSalesLogs);
        	    	    	
    	//ActionListeners for the Buttons
	    importItems.addActionListener(new ImportItems());
	    exportManifestButton.addActionListener(new ExportManifest());
	    importSalesLogs.addActionListener(new ImportSalesLogs());
	    importManifest.addActionListener(new ImportManifest());
	    
	    //Set layout of inventory panel
	    inventory.setLayout(new BorderLayout());
	    
	    //Add the capital label panel to the inventory panel
	    inventory.add(capitalLabel, BorderLayout.NORTH);
	       	
	    //Create Item properties table and populate with nothing
		itemTable = new JTable(itemTableModel);
		itemScroll = new JScrollPane(itemTable);
		inventory.add(itemScroll, BorderLayout.CENTER);	
		
		//Add the inventory tab to the tabbedPane
		tabbedPane.add("Inventory", inventory);

		//Add everything to the GUI
		add(buttons, BorderLayout.PAGE_START);
		add(tabbedPane, BorderLayout.CENTER);
			
	}
}
