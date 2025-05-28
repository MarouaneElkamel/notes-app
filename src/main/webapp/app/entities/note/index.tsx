import React from 'react';
import { Route } from 'react-router';

import ErrorBoundaryRoutes from 'app/shared/error/error-boundary-routes';

import Note from './note';
import NoteDetail from './note-detail';
import NoteUpdate from './note-update';
import NoteDeleteDialog from './note-delete-dialog';

const NoteRoutes = () => (
  <ErrorBoundaryRoutes>
    <Route index element={<Note />} />
    <Route path="new" element={<NoteUpdate />} />
    <Route path=":id">
      <Route index element={<NoteDetail />} />
      <Route path="edit" element={<NoteUpdate />} />
      <Route path="delete" element={<NoteDeleteDialog />} />
    </Route>
  </ErrorBoundaryRoutes>
);

export default NoteRoutes;
