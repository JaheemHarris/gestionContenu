<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Contenu</h1>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Liste des contenus</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Titre</th>
                            <th>Type</th>
                            <th>Date de publication</th>
                            <th>Fichier</th>
                            <th>Détails</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>Titre</th>
                            <th>Type</th>
                            <th>Date de publication</th>
                            <th>Fichier</th>
                            <th>Détails</th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <% for (int i = 0; i < 5; i++) { %>
                        <tr>
                            <td>Nouveau partenariat</td>
                            <td>Rapport de mission</td>
                            <td>21 Novembre 2021</td>
                            <td>Pdf</td>
                            <td>
                                <a href="#" class="btn btn-primary btn-icon-split">
                                    <span class="icon text-white-50">
                                        <i class="fas fa-eye"></i>
                                    </span>
                                    <span class="text">Voir</span>
                                </a>
                            </td>
                        </tr>
                        <% }%>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>