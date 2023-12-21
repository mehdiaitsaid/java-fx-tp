package lst.fsts.javafxtps;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class IndexController implements Initializable {

    private int selectedId;

    @FXML
    private Button add;
    @FXML
    private Button update;
    @FXML
    private Button delete;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private TextField email;

    @FXML
    private TextField cne;
    @FXML
    private TableView<Etudiant> etudiantsList;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // TODO (don't really need to do anything here).
        Db.addEtudiant("Mehdi", "Ait Said", "m.aitsaid@uhp.ac.ma", "1300000000");
        Db.addEtudiant("Achraf", "Banir", "testd@uhp.ac.ma", "131111111");
        etudiantsList.getItems().setAll(Db.getAllEtudiants());


    }

    public void addEtudiant(ActionEvent event) {

        Db.addEtudiant(this.nom.getText(), this.prenom.getText(), this.email.getText(), this.cne.getText());
        etudiantsList.getItems().setAll(Db.getAllEtudiants());
        this.reload();

    }

    public void updateEtudiant(ActionEvent event) {

        Db.updateEtudiant(this.selectedId, this.nom.getText(), this.prenom.getText(), this.email.getText(), this.cne.getText());
        etudiantsList.getItems().setAll(Db.getAllEtudiants());
        this.reload();

    }

    public void deleteEtudiant(ActionEvent event) {


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Voulez vous vraiment effectuer cette opération?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            Db.deleteEtudiantById(this.selectedId);
            etudiantsList.getItems().setAll(Db.getAllEtudiants());
            this.reload();
        } else {
            // ... user chose CANCEL or closed the dialog
        }

    }

    @FXML
    private void handleClickTableView(MouseEvent click) {
        Etudiant etudiant = etudiantsList.getSelectionModel().getSelectedItem();
        if (etudiant != null) {
            this.nom.setText(etudiant.getNom());
            this.prenom.setText(etudiant.getPrenom());
            this.email.setText(etudiant.getEmail());
            this.cne.setText(etudiant.getCne());
            this.selectedId = etudiant.getId();
            this.update.setVisible(true);
            this.delete.setVisible(true);

        }
    }


    private void reload() {
        this.nom.setText("");
        this.prenom.setText("");
        this.email.setText("");
        this.cne.setText("");
        this.update.setVisible(false);
        this.delete.setVisible(false);
        this.selectedId = 0;
    }


    // When user click on myButton
    // this method will be called.
//    public void showDateTime(ActionEvent event) {
//
////        Node node = (Node) event.getSource() ;
////        String data = (String) node.getUserData();
////        int value = Integer.parseInt(data);
////        System.out.println("Button Clicked!" + event.getEventType().getName() );
////
////        Date now= new Date();
////
////        DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
////
////
////        // Model Data
////        String dateTimeString = df.format(now);
////
////        // Show in VIEW
////        myTextField.setText(dateTimeString);
//
//    }

}
